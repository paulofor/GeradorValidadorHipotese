package jet.angular.projeto;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class PackageJson
{
  protected static String nl;
  public static synchronized PackageJson create(String lineSeparator)
  {
    nl = lineSeparator;
    PackageJson result = new PackageJson();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "{" + NL + "  \"name\": \"projeto\"," + NL + "  \"version\": \"1.0.0\"," + NL + "  \"license\": \"MIT\"," + NL + "  \"scripts\": {" + NL + "    \"ng\": \"ng\"," + NL + "    \"start\": \"ng serve\"," + NL + "    \"build\": \"ng build --prod\"," + NL + "    \"test\": \"ng test\"," + NL + "    \"lint\": \"ng lint\"," + NL + "    \"e2e\": \"ng e2e\"" + NL + "  }," + NL + "  \"private\": true," + NL + "  \"dependencies\": {" + NL + "    \"@angular/animations\": \"^5.2.0\"," + NL + "    \"@angular/cdk\": \"5.2.0\"," + NL + "    \"@angular/common\": \"^5.2.0\"," + NL + "    \"@angular/compiler\": \"^5.2.0\"," + NL + "    \"@angular/core\": \"^5.2.0\"," + NL + "    \"@angular/flex-layout\": \"^5.0.0-beta.15\"," + NL + "    \"@angular/forms\": \"^5.2.0\"," + NL + "    \"@angular/http\": \"^5.2.0\"," + NL + "    \"@angular/material\": \"5.2.4\"," + NL + "    \"@angular/platform-browser\": \"^5.2.0\"," + NL + "    \"@angular/platform-browser-dynamic\": \"^5.2.0\"," + NL + "    \"@angular/router\": \"^5.2.0\"," + NL + "    \"bootstrap\": \"3.3.7\"," + NL + "    \"core-js\": \"^2.4.1\"," + NL + "    \"jquery\": \"^1.9.1\"," + NL + "    \"popper.js\": \"^1.14.3\"," + NL + "    \"rxjs\": \"^5.5.6\"," + NL + "    \"zone.js\": \"^0.8.19\"" + NL + "  }," + NL + "  \"devDependencies\": {" + NL + "    \"@angular/cli\": \"~1.7.4\"," + NL + "    \"@angular/compiler-cli\": \"^5.2.0\"," + NL + "    \"@angular/language-service\": \"^5.2.0\"," + NL + "    \"@types/jasmine\": \"~2.8.3\"," + NL + "    \"@types/jasminewd2\": \"~2.0.2\"," + NL + "    \"@types/node\": \"~6.0.60\"," + NL + "    \"codelyzer\": \"^4.0.1\"," + NL + "    \"jasmine-core\": \"~2.8.0\"," + NL + "    \"jasmine-spec-reporter\": \"~4.2.1\"," + NL + "    \"karma\": \"~2.0.0\"," + NL + "    \"karma-chrome-launcher\": \"~2.2.0\"," + NL + "    \"karma-coverage-istanbul-reporter\": \"^1.2.1\"," + NL + "    \"karma-jasmine\": \"~1.1.0\"," + NL + "    \"karma-jasmine-html-reporter\": \"^0.2.2\"," + NL + "    \"protractor\": \"~5.1.2\"," + NL + "    \"ts-node\": \"~4.1.0\"," + NL + "    \"tslint\": \"~5.9.1\"," + NL + "    \"typescript\": \"~2.5.3\"" + NL + "  }" + NL + "}";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapperAngular classe = (ClasseWrapperAngular) recursos.getClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
