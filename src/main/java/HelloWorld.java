import static com.teamdev.jxbrowser.engine.RenderingMode.*;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.*;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class HelloWorld
{
  public static void main(String[] args)
  {
    Engine engine = Engine.newInstance(EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey(
      "1BNDHFSC1G0LG30NVYOT1879Z6LBSB4ZTB3NGH1FEL0B2IILHMH5VCP1C42W92V1UD0TA7").build());
    Browser browser = engine.newBrowser();

    SwingUtilities.invokeLater(() -> {
      BrowserView view = BrowserView.newInstance(browser);

      JFrame frame = new JFrame("Swing BrowserView");
      frame.add(view, BorderLayout.CENTER);
      frame.setSize(700, 500);
      frame.setVisible(true);

      browser.navigation().loadUrl("https://iesl.lk/index.php?lang=en");
    });
  }
}
