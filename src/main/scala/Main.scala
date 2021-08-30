import chisel3._
import chisel3.stage.ChiselStage

class Example extends MultiIOModule {
  val in = IO(Input(Bool()))
  val out= IO(Output(Bool()))

  val fooOut = IO(Output(Vec(4, new Bundle {})))
  val fooIn = IO(Input(Vec(4, new Bundle {})))

  fooOut := fooIn
  val thisWorks = Reg(new Bundle {})
  val myReg = RegInit(fooIn)
  fooOut := myReg

  out := in
}

object Main extends App {
  println(ChiselStage.emitVerilog(gen = new Example))
}

