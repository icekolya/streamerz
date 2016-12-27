package examples

import akka.actor.ActorSystem
import akka.stream.ActorMaterializerSettings
import com.jsuereth.video.filters.HorizontalFlipFilter
import com.jsuereth.video.swing


object WebcamPlayer {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()
    val settings = ActorMaterializerSettings.create(system)
    def video() = com.jsuereth.video.WebCam.default(system)

    import com.jsuereth.video.AsciiToVideo.asciiToVideo
    swing.createVideoPlayer(system, video)(

    )
  }
}
