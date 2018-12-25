package jet.angular;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class PageModuleTs
{
  protected static String nl;
  public static synchronized PageModuleTs create(String lineSeparator)
  {
    nl = lineSeparator;
    PageModuleTs result = new PageModuleTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + NL + "import { NgModule } from '@angular/core';" + NL + "import { TranslateModule } from '@ngx-translate/core';" + NL + "import { IonicPageModule } from 'ionic-angular';" + NL + "" + NL + "import { ItemCreatePage } from './item-create';" + NL + "" + NL + "@NgModule({" + NL + "  declarations: [" + NL + "    ItemCreatePage," + NL + "  ]," + NL + "  imports: [" + NL + "    IonicPageModule.forChild(ItemCreatePage)," + NL + "    TranslateModule.forChild()" + NL + "  ]," + NL + "  exports: [" + NL + "    ItemCreatePage" + NL + "  ]" + NL + "})" + NL + "export class ItemCreatePageModule { }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
