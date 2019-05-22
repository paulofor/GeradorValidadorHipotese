package jet.ionic3.app;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;
import loopback.cliente.modelo.*;

public class ThemeVariables
{
  protected static String nl;
  public static synchronized ThemeVariables create(String lineSeparator)
  {
    nl = lineSeparator;
    ThemeVariables result = new ThemeVariables();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "// Ionic Variables and Theming. For more info, please see:" + NL + "// http://ionicframework.com/docs/theming/" + NL + "" + NL + "// Font path is used to include ionicons," + NL + "// roboto, and noto sans fonts" + NL + "$font-path: \"../assets/fonts\";" + NL + "" + NL + "" + NL + "// The app direction is used to include" + NL + "// rtl styles in your app. For more info, please see:" + NL + "// http://ionicframework.com/docs/theming/rtl-support/" + NL + "$app-direction: ltr;" + NL + "" + NL + "" + NL + "@import \"ionic.globals\";" + NL + "" + NL + "" + NL + "// Shared Variables" + NL + "// --------------------------------------------------" + NL + "// To customize the look and feel of this app, you can override" + NL + "// the Sass variables found in Ionic's source scss files." + NL + "// To view all the possible Ionic variables, see:" + NL + "// http://ionicframework.com/docs/theming/overriding-ionic-variables/" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "// Named Color Variables" + NL + "// --------------------------------------------------" + NL + "// Named colors makes it easy to reuse colors on various components." + NL + "// It's highly recommended to change the default colors" + NL + "// to match your app's branding. Ionic uses a Sass map of" + NL + "// colors so you can add, rename and remove colors as needed." + NL + "// The \"primary\" color is the only required color in the map." + NL + "" + NL + "$colors: (" + NL + "  primary:    ";
  protected final String TEXT_3 = "," + NL + "  secondary:  ";
  protected final String TEXT_4 = "," + NL + "  danger:     #f53d3d," + NL + "  light:      #f4f4f4," + NL + "  dark:       #222," + NL + "  titulo:   ";
  protected final String TEXT_5 = "," + NL + "  botao:      ";
  protected final String TEXT_6 = "," + NL + ");" + NL + "" + NL + "" + NL + "// App iOS Variables" + NL + "// --------------------------------------------------" + NL + "// iOS only Sass variables can go here" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "// App Material Design Variables" + NL + "// --------------------------------------------------" + NL + "// Material Design only Sass variables can go here" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "// App Windows Variables" + NL + "// --------------------------------------------------" + NL + "// Windows only Sass variables can go here" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "// App Theme" + NL + "// --------------------------------------------------" + NL + "// Ionic apps can have different themes applied, which can" + NL + "// then be future customized. This import comes last" + NL + "// so that the above variables are used and Ionic's" + NL + "// default are overridden." + NL + "" + NL + "@import \"ionic.theme.default\";" + NL + "" + NL + "" + NL + "// Ionicons" + NL + "// --------------------------------------------------" + NL + "// The premium icon font for Ionic. For more info, please see:" + NL + "// http://ionicframework.com/docs/ionicons/" + NL + "" + NL + "@import \"ionic.ionicons\";" + NL + "" + NL + "" + NL + "// Fonts" + NL + "// --------------------------------------------------" + NL + "" + NL + "@import \"roboto\";" + NL + "@import \"noto-sans\";";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
PaletaCorRest paleta = recursos.getPaletaCor();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( paleta.getCor1() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( paleta.getCor2() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( paleta.getCor1() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( paleta.getCor1() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
