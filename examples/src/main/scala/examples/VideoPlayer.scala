package examples

import akka.actor.ActorSystem
import akka.stream.ActorMaterializerSettings
import akka.stream.scaladsl.{Sink, Source}
import com.jsuereth.video.filters.FiltersRegistrator
import com.jsuereth.video.{AsciiVideoFrame, swing}


object VideoPlayer {
  def main(args: Array[String]): Unit = {
    //val url = new java.io.File("goose.mp4").toURI.toASCIIString
    //val url = "http://vdownload.eu/webproxy/12409v4/55134921/3rdparty/e2c873d2d1.480.mp4/Rick%20Roll%20%E2%80%94%20Never%20Gonna%20Give%20You%20Up.mp4"
    val url = "file:E:/Projects/Scala/streamerz/videos/slow_motion_back_flip.mp4"
    implicit val system = ActorSystem()
    val settings = ActorMaterializerSettings.create(system)
    def video() = com.jsuereth.video.ffmpeg.readVideoURI(new java.net.URI(url), system, playAudio = false)
    FiltersRegistrator()
    swing.createVideoPlayer(system, video)()
  }
}
