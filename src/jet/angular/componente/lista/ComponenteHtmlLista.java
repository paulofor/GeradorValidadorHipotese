package jet.angular.componente.lista;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class ComponenteHtmlLista
{
  protected static String nl;
  public static synchronized ComponenteHtmlLista create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponenteHtmlLista result = new ComponenteHtmlLista();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "<div class=\"main-content\">" + NL + "  <div class=\"container-fluid\">" + NL + "    <div class=\"row\">" + NL + "      <div class=\"col-md-12\">" + NL + "        <div class=\"card\">" + NL + "          <div class=\"header\">" + NL + "            <h4 class=\"title\">Valida??o de Hip?teses de Valor</h4>" + NL + "          </div>" + NL + "          <div class=\"content table-responsive table-full-width\">" + NL + "            <table class=\"table table-hover table-striped\">" + NL + "              <thead>" + NL + "                <tr>" + NL + "                  <th>Projeto</th>" + NL + "                  <th>Mercado</th>" + NL + "                  <th></th>" + NL + "                </tr>" + NL + "              </thead>" + NL + "              <tbody>" + NL + "                <tr *ngFor=\"let item of itens\">" + NL + "                  <td>{{projeto.nome}}</td>" + NL + "                  <td>{{projeto.mercado}}</td>" + NL + "                  <td><a routerLink=\"/projetosValor/{{projeto.id}}\">Gerenciar</a></td>" + NL + "                </tr>" + NL + "              </tbody>" + NL + "            </table>" + NL + "" + NL + "          </div>" + NL + "        </div>" + NL + "      </div>" + NL + "" + NL + "    </div>" + NL + "  </div>" + NL + "</div>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapperAngular classe = (ClasseWrapperAngular) recursos.getClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
