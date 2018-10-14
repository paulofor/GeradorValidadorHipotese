package jet.angular;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class TelaListaEdicaoBase
{
  protected static String nl;
  public static synchronized TelaListaEdicaoBase create(String lineSeparator)
  {
    nl = lineSeparator;
    TelaListaEdicaoBase result = new TelaListaEdicaoBase();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package  ";
  protected final String TEXT_3 = ".tela.listaedicao.base;" + NL + "" + NL + "import ";
  protected final String TEXT_4 = ".app.R;" + NL + "import ";
  protected final String TEXT_5 = ".modelo.*;" + NL + "import ";
  protected final String TEXT_6 = ".modelo.agregado.*;" + NL + "import ";
  protected final String TEXT_7 = ".servico.*;" + NL + "import ";
  protected final String TEXT_8 = ".view.adapter.";
  protected final String TEXT_9 = "ListAdapter;" + NL + "import ";
  protected final String TEXT_10 = ".view.adapter.listaedicao.";
  protected final String TEXT_11 = "ListEdicaoAdapter;" + NL + "import ";
  protected final String TEXT_12 = ".modelo.vo.FabricaVo;" + NL + "import ";
  protected final String TEXT_13 = ".servico.";
  protected final String TEXT_14 = "Servico;" + NL + "import ";
  protected final String TEXT_15 = ".app.Constantes;" + NL + "import android.widget.BaseAdapter;" + NL + "" + NL + "import java.util.List;" + NL + "import br.com.digicom.quadro.*;" + NL + "import android.content.Context;" + NL + "import android.os.Bundle;" + NL + "import android.view.LayoutInflater;" + NL + "import android.view.View;" + NL + "import android.view.ViewGroup;" + NL + "import android.view.View.OnClickListener;" + NL + "import android.widget.ListView;" + NL + "import android.widget.Button;" + NL + "import br.com.digicom.multimidia.AudioRecurso;" + NL + "import br.com.digicom.activity.DigicomContexto;" + NL + "import br.com.digicom.log.DCLog;" + NL + "import br.com.digicom.layout.ResourceObj;" + NL + "import br.com.digicom.animacao.TrocaQuadro;" + NL + "" + NL + "import android.app.Fragment;" + NL + "import android.app.FragmentTransaction;" + NL + "" + NL + "import br.com.digicom.log.DCLog;" + NL + "import android.util.Log;" + NL + "import br.com.digicom.modelo.DCIObjetoDominio;" + NL + "import br.com.digicom.servico.ServicoLocal;" + NL + "import br.com.digicom.animacao.TrocaQuadro;" + NL + "" + NL + "public abstract class ";
  protected final String TEXT_16 = "ListaEdicaoBase extends BaseListFragment implements IQuadroListaEdicao  " + NL + "\t";
  protected final String TEXT_17 = ", DialogListListener ";
  protected final String TEXT_18 = "{" + NL + "" + NL + "\tpublic final static String ITEM_CLICK = \"";
  protected final String TEXT_19 = "ItemClick\";" + NL + "" + NL + "\tprivate ";
  protected final String TEXT_20 = "ListEdicaoAdapter adapt = null;" + NL + "\tprivate List<";
  protected final String TEXT_21 = "> lista = null;" + NL + "\tprivate Button btnCriaItem = null;" + NL + "\t" + NL + "\tprivate boolean salvaPreliminar = false;" + NL + "\t" + NL + "\tprivate ";
  protected final String TEXT_22 = "Servico servico = null;" + NL + "" + NL + "\tpublic BaseAdapter getAdapter() {" + NL + "\t\treturn adapt;" + NL + "\t}" + NL + "\t" + NL + "\tprotected void setSalvaPreliminar(boolean valor) {" + NL + "\t\tsalvaPreliminar = valor;" + NL + "\t}" + NL + "\t" + NL + "\tprotected ";
  protected final String TEXT_23 = "Servico getServico() {" + NL + "\t\treturn servico;" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tprotected final void inicializaItensTelaBase() {" + NL + "\t\tbtnCriaItem = (Button) getTela().findViewById(R.id.btnCria";
  protected final String TEXT_24 = ");" + NL + "\t\tlogObjetoInterno();" + NL + "\t}" + NL + "\t@Override" + NL + "\tprotected final void inicializaListenersBase() {" + NL + "\t\tbtnCriaItem.setOnClickListener(new OnClickListener() {" + NL + "\t\t\t@Override" + NL + "\t\t\tpublic void onClick(View v) {" + NL + "\t\t\t\tchamaCriaItem();" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "\t@Override" + NL + "\tprotected final void inicializaServicosBase() {" + NL + "\t\tservico = FabricaServico.getInstancia().get";
  protected final String TEXT_25 = "Servico(FabricaServico.TIPO_SQLITE);" + NL + "\t\t" + NL + "\t}" + NL + "" + NL + "\t" + NL + "\t// Nao passo para a arquitetura pq criaQuadroTrata e " + NL + "\t// especifico de ListaEdicao que ? um conceito de template." + NL + "\t@Override" + NL + "\tpublic void onToqueLongoTela(DCIObjetoDominio obj) {" + NL + "\t\tBundleFragment bundle = new BundleFragment();" + NL + "\t\tbundle.setObjeto(Constantes.CHAVE_ALTERACAO, true);" + NL + "\t\tbundle.setObjeto(Constantes.CHAVE_";
  protected final String TEXT_26 = ", obj);" + NL + "\t\tIFragmentEdicao quadro = criaQuadroTrata(bundle);" + NL + "\t\tTrocaQuadro.getInstancia().alteraQuadroPrincipal(quadro);" + NL + "\t}" + NL + "" + NL + "\tprotected void atualizaListaTela() {" + NL + "\t\tpreencheLista(); // Talvez nao precise fazer isso sempre j? que existe o adapt.notifyDataSetChanged" + NL + "\t\t" + NL + "\t}" + NL + "\t" + NL + "" + NL + "\t@Override" + NL + "\tpublic void audioRawConcluido(AudioRecurso audioRecurso) {" + NL + "\t}" + NL + "" + NL + "\tprotected String getPalavraChave() {" + NL + "\t\treturn ITEM_CLICK;" + NL + "\t}" + NL + "" + NL + "\t" + NL + "" + NL + "\tpublic void onStart() {" + NL + "\t\tsuper.onStart();" + NL + "\t\tatualizaListaTela();" + NL + "\t\t// Ao se conhecer melhor o ciclo de vida dos fragments pensar em otimizar esse trecho" + NL + "\t\t// evitar processar algo que n?o muda e evitar n?o processar algo que muda." + NL + "\t\t// Fazendo um algoritmo que sirva para fragments de smartphone, que fica um por tela" + NL + "\t\t// Quanto de tablet que pode ficar mais de um" + NL + "\t\t// Decidir ate 28-06-2014" + NL + "\t}" + NL + "\t" + NL + "" + NL + "\t@Override" + NL + "\tprotected ResourceObj getLayoutTela() {" + NL + "\t\tResourceObj recurso = new ResourceObj(R.layout.lista_";
  protected final String TEXT_27 = ",\"R.layout.lista_";
  protected final String TEXT_28 = "\");" + NL + "\t\treturn recurso;" + NL + "\t}" + NL + "\t// Dois metodos com mesmo objetivo. Excluir at? 21-07-2015 ( 3 meses )" + NL + "\t// TelaListaUsoBase, TelaQuadroListaBase, ViewBase, TelaListaEdicaoBase" + NL + "\t" + NL + "" + NL + "\t";
  protected final String TEXT_29 = NL + "\t// Delegando a cria??o de objeto ao inicializaItemTela na camada servico" + NL + "\tpublic final void chamaCriaItem() {" + NL + "\t\t//";
  protected final String TEXT_30 = " nova = servico.inicializaItemTela(getContext());" + NL + "\t\t";
  protected final String TEXT_31 = " nova = FabricaVo.cria";
  protected final String TEXT_32 = "();" + NL + "\t\tnova = insereObjetoPrincipal(nova);" + NL + "\t\tnova = (";
  protected final String TEXT_33 = ") ((ServicoLocal)servico).atribuiUsuario(nova);" + NL + "\t\tnova = servico.inicializaItemTela(nova,getContext());" + NL + "\t\tBundleFragment bundle = new BundleFragment();" + NL + "\t\tbundle.setObjeto(Constantes.CHAVE_";
  protected final String TEXT_34 = ", nova);" + NL + "\t\tbundle.setObjeto(Constantes.CHAVE_ALTERACAO, !nova.getSomenteMemoria());" + NL + "\t\tIFragmentEdicao quadro = criaQuadroTrata(bundle);" + NL + "\t\tquadro.setBundle(bundle);" + NL + "\t\texibeQuadro(quadro);" + NL + "\t}" + NL + "\t// Pode ser usado outro metodo de apresentacao na classe filha." + NL + "\tprotected void exibeQuadro(IFragment quadro) {" + NL + "\t\tTrocaQuadro.getInstancia().alteraQuadroPrincipal(quadro);" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_35 = NL + "\t// Um objeto Associativo" + NL + "\t";
  protected final String TEXT_36 = NL + "\t// Com atributos" + NL + "\tpublic void chamaCriaItem() {" + NL + "\t";
  protected final String TEXT_37 = NL + "\t// Sem atributos" + NL + "\tpublic final void chamaCriaItem() {" + NL + "\t";
  protected final String TEXT_38 = NL + "\t\tDialogListListener listener = (DialogListListener) this;\t" + NL + "\t\tBundleFragment bundle = new BundleFragment();" + NL + "\t\tbundle.setObjeto(BaseDialogListFragment.CHAVE_LISTA_ESCOLHIDOS, this.lista);" + NL + "\t\tbundle.setObjeto(BaseDialogListFragment.CHAVE_LISTA_TOTAL, getListaItensDialog());" + NL + "\t\tBaseDialogListFragment dialog = criaDialog(bundle);" + NL + "\t\tdialog.show(getActivity().getFragmentManager(), \"TagLista";
  protected final String TEXT_39 = "Dialog\");" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic final void onDialogNegativeClick(List<DCIObjetoDominio> listaEscolhidos) {" + NL + "\t}" + NL + "\t" + NL + "\tprotected BaseDialogListFragment criaDialog(BundleFragment bundle) {" + NL + "\t\tthrow new UnsupportedOperationException(\"Fazer override de criaDialog em ";
  protected final String TEXT_40 = "ListaEdicao com return new ";
  protected final String TEXT_41 = "QuadroTrata extends DialogListFragment\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_42 = NL + "\t" + NL + "\t" + NL + "\t" + NL + "\t/*" + NL + "\tprotected ";
  protected final String TEXT_43 = " criaNova() {" + NL + "\t\treturn servico.inicializaItemTela(getContext());" + NL + "\t\t//throw new UnsupportedOperationException(\"Fazer override de criaNova em ";
  protected final String TEXT_44 = "QuadroLista retornando new ";
  protected final String TEXT_45 = " com inicializa??o de listas internas se necessario\");" + NL + "\t\t// Exemplo - Criar inicializando dados e listas internas " + NL + "\t\tprotected SerieTreino criaNova() {" + NL + "\t\t\tSerieTreino nova = FabricaVo.criaSerieTreino();" + NL + "\t\t\tnova.setDataInicial(UtilDatas.getTimestampAtual());" + NL + "\t\t\tList<ItemSerie> lista = new ArrayList<ItemSerie>();" + NL + "\t\t\tnova.setListaItemSerie_Possui(lista);" + NL + "\t\t\treturn nova;" + NL + "\t\t}" + NL + "\t}" + NL + "\t*/" + NL + "\t" + NL + "\tprotected IFragmentEdicao criaQuadroTrata(BundleFragment bundle) {" + NL + "\t\tthrow new UnsupportedOperationException(\"Fazer override de criaQuadroTrata em ";
  protected final String TEXT_46 = "ListaEdicao retornando new ";
  protected final String TEXT_47 = "QuadroTrata ou verificar se nao esta sendo chamada via super\");" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void onToqueTela(DCIObjetoDominio obj) {" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tprotected void inicializaItensTela() {" + NL + "\t}" + NL + "\t@Override" + NL + "\tprotected void inicializaListeners() {" + NL + "\t}" + NL + "\t@Override" + NL + "\tprotected void inicializaServicos() {" + NL + "\t}" + NL + "\t@Override" + NL + "\tpublic void onAlteraQuadro() {" + NL + "\t\tatualizaListaTela();" + NL + "\t}" + NL + "\t" + NL + "\tprotected void preencheLista() {" + NL + "        //ListView lista = (ListView) getActivity().findViewById(R.id.listViewPrincipal);";
  protected final String TEXT_48 = NL + "        ";
  protected final String TEXT_49 = "Servico servico = FabricaServico.getInstancia().get";
  protected final String TEXT_50 = "Servico(FabricaServico.TIPO_SQLITE);" + NL + "        DigicomContexto dContexto = getContext();" + NL + "        lista = getListaCorrente(dContexto.getContext(),servico);" + NL + "        DCLog.d(DCLog.SERVICO_QUADRO_LISTA, this, \"preencheLista : List<";
  protected final String TEXT_51 = "> -> \" + lista.size() + \" itens\");" + NL + "        // Pode ser necessario um adapter customizado (diferenciar o editar e usar)" + NL + "        adapt =  getAdapter(lista, dContexto);" + NL + "        //adapt.setRaiz(this);" + NL + "        setListAdapter(adapt);" + NL + "        adapt.notifyDataSetChanged(); " + NL + "\t}" + NL + "\t" + NL + "\tprivate ";
  protected final String TEXT_52 = "ListEdicaoAdapter getAdapter(List<";
  protected final String TEXT_53 = "> lista,DigicomContexto dContexto) {" + NL + "\t\treturn new ";
  protected final String TEXT_54 = "ListEdicaoAdapter(lista,this,dContexto.getContext());" + NL + "\t}" + NL + "\t" + NL + "" + NL + "" + NL + "\t";
  protected final String TEXT_55 = NL + "\t// Tratamento Especial para Tela a serem embutidas." + NL + "\tprotected ";
  protected final String TEXT_56 = " item1 = null;" + NL + "\tprotected ";
  protected final String TEXT_57 = " item2 = null;" + NL + "\tpublic void set";
  protected final String TEXT_58 = "(";
  protected final String TEXT_59 = " valor) {" + NL + "\t\titem1 = valor;" + NL + "\t}" + NL + "\tpublic void set";
  protected final String TEXT_60 = "(";
  protected final String TEXT_61 = " valor) {" + NL + "\t\titem2 = valor;" + NL + "\t}" + NL + "\tpublic void logObjetoInterno() {" + NL + "\t\tDCLog.d(DCLog.OBJETO_INTERNO, this, \"item1 = \"  + item1 + \"(\" + (item1!=null?item1.getClass().getSimpleName():\"-\") + \")\");" + NL + "\t\tDCLog.d(DCLog.OBJETO_INTERNO, this, \"item2 = \"  + item2 + \"(\" + (item2!=null?item2.getClass().getSimpleName():\"-\") + \")\");" + NL + "\t}" + NL + "\tpublic List<";
  protected final String TEXT_62 = "> getListaCorrente(Context contexto, ";
  protected final String TEXT_63 = "Servico servico) {" + NL + "\t\tList<";
  protected final String TEXT_64 = "> listaSaida = null;" + NL + "\t\tif (item1==null && item2==null) {" + NL + "\t\t\tthrow new QuadroException(this,\"Precisa setar um dos objetos\");" + NL + "\t\t}" + NL + "\t\tif (item1!=null) {" + NL + "\t\t\tlistaSaida = servico.getPor";
  protected final String TEXT_65 = "(contexto, item1.getId());" + NL + "\t\t}" + NL + "\t\tif (item2!=null) {" + NL + "\t\t\tlistaSaida = servico.getPor";
  protected final String TEXT_66 = "(contexto, item2.getId());" + NL + "\t\t}" + NL + "\t\treturn listaSaida;" + NL + "\t}" + NL + "\tprotected List getListaItensDialog() {" + NL + "\t\tList listaSaida = null;" + NL + "\t\tif (item1==null && item2==null) {" + NL + "\t\t\tthrow new QuadroException(this,\"Precisa setar um dos objetos\");" + NL + "\t\t}" + NL + "\t\tif (item1!=null) {" + NL + "\t\t\t";
  protected final String TEXT_67 = "Servico srv = FabricaServico.getInstancia().get";
  protected final String TEXT_68 = "Servico(FabricaServico.TIPO_SQLITE);" + NL + "\t\t\tlistaSaida = srv.getAllTela(this.getContext().getContext());" + NL + "\t\t}" + NL + "\t\tif (item2!=null) {" + NL + "\t\t\t";
  protected final String TEXT_69 = "Servico srv = FabricaServico.getInstancia().get";
  protected final String TEXT_70 = "Servico(FabricaServico.TIPO_SQLITE);" + NL + "\t\t\tlistaSaida = srv.getAllTela(this.getContext().getContext());" + NL + "\t\t}" + NL + "\t\treturn listaSaida;" + NL + "\t}" + NL + "\tpublic void onDialogPositiveClick(List<DCIObjetoDominio> listaEscolhidos) {" + NL + "\t\tif (item1==null && item2==null) {" + NL + "\t\t\tthrow new QuadroException(this,\"Precisa setar um dos objetos\");" + NL + "\t\t}" + NL + "\t\tif (item1!=null) {" + NL + "\t\t\tthis.getServico().atualizaRelacionamento(item1, listaEscolhidos);" + NL + "\t\t\tthis.atualizaListaTela();" + NL + "\t\t}" + NL + "\t\tif (item2!=null) {" + NL + "\t\t\tthis.getServico().atualizaRelacionamento(item2, listaEscolhidos);" + NL + "\t\t\tthis.atualizaListaTela();" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_71 = NL + "\t" + NL + "\t";
  protected final String TEXT_72 = NL + "\tpublic void logObjetoInterno() {" + NL + "\t}" + NL + "\t";
  protected final String TEXT_73 = NL + "\t" + NL + "\t// Classes dependentes para n?o associativas" + NL + "\tprivate ";
  protected final String TEXT_74 = " ";
  protected final String TEXT_75 = ";" + NL + "\tpublic final void set";
  protected final String TEXT_76 = "(";
  protected final String TEXT_77 = " valor) {" + NL + "\t\t";
  protected final String TEXT_78 = " = valor;" + NL + "\t\t";
  protected final String TEXT_79 = ".setContexto(getContext());" + NL + "\t}" + NL + "\tprotected final ";
  protected final String TEXT_80 = " get";
  protected final String TEXT_81 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_82 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_83 = NL + "\t" + NL + "\t";
  protected final String TEXT_84 = NL + "\tprivate ";
  protected final String TEXT_85 = " insereObjetoPrincipal(";
  protected final String TEXT_86 = " item) {" + NL + "\t\tif (item1!=null) {" + NL + "\t\t\titem.set";
  protected final String TEXT_87 = "_";
  protected final String TEXT_88 = "(item1);" + NL + "\t\t}" + NL + "\t\tif (item2!=null) {" + NL + "\t\t\titem.set";
  protected final String TEXT_89 = "_";
  protected final String TEXT_90 = "(item2);" + NL + "\t\t}" + NL + "\t\treturn item;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_91 = NL + "\tprivate ";
  protected final String TEXT_92 = " insereObjetoPrincipal(";
  protected final String TEXT_93 = " item) {" + NL + "\t";
  protected final String TEXT_94 = NL + "\t\titem.set";
  protected final String TEXT_95 = "_";
  protected final String TEXT_96 = "(";
  protected final String TEXT_97 = ");" + NL + "\t";
  protected final String TEXT_98 = NL + "\t\treturn item;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_99 = NL + "\tprotected List<";
  protected final String TEXT_100 = "> getListaCorrente(Context contexto, ";
  protected final String TEXT_101 = "Servico servico) {" + NL + "\t\tList<";
  protected final String TEXT_102 = "> listaSaida = null;" + NL + "\t\t";
  protected final String TEXT_103 = NL + "\t\tif (";
  protected final String TEXT_104 = "!=null) {" + NL + "\t\t\tlistaSaida = servico.getPor";
  protected final String TEXT_105 = "(contexto, ";
  protected final String TEXT_106 = ".getId());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_107 = NL + "\t\treturn listaSaida;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_108 = NL + "\t";
  protected final String TEXT_109 = NL + "\tprotected List<";
  protected final String TEXT_110 = "> getListaCorrente(Context contexto,";
  protected final String TEXT_111 = "Servico servico) {" + NL + "\t\tList<";
  protected final String TEXT_112 = "> saida = servico.getAllTela(contexto);" + NL + "\t\treturn saida;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_113 = NL + "\t";
  protected final String TEXT_114 = NL + "\t" + NL + "\t";
  protected final String TEXT_115 = NL + "\t" + NL + "\t" + NL + "\t";
  protected final String TEXT_116 = NL + "\t@Override" + NL + "\tpublic final void extraiBundle() {" + NL + "\t\tBundleFragment bundle = this.getBundle();" + NL + "\t\titem1 = (";
  protected final String TEXT_117 = ") bundle.getObjetoPermiteNull(Constantes.CHAVE_";
  protected final String TEXT_118 = ");" + NL + "\t\titem2 = (";
  protected final String TEXT_119 = ") bundle.getObjetoPermiteNull(Constantes.CHAVE_";
  protected final String TEXT_120 = ");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_121 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapper classe = recursos.getClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( conf.getNamespace() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_16);
     if (classe.isAssociativa()) 
    stringBuffer.append(TEXT_17);
     ; 
    stringBuffer.append(TEXT_18);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( classe.getNomeParaConstante() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( classe.getNomeParaTabela() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( classe.getNomeParaTabela() );
    stringBuffer.append(TEXT_28);
    
	if (!classe.isAssociativa() || (classe.isAssociativa() && classe.qtdeAtributo()>1)) {
	
    stringBuffer.append(TEXT_29);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( classe.getNomeParaConstante() );
    stringBuffer.append(TEXT_34);
    
	} else {
	
    stringBuffer.append(TEXT_35);
    
	if (classe.qtdeAtributo()>1) {
	
    stringBuffer.append(TEXT_36);
     } else { 
    stringBuffer.append(TEXT_37);
     } 
    stringBuffer.append(TEXT_38);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_41);
    
	}
	
    stringBuffer.append(TEXT_42);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_54);
    
	if (classe.isAssociativa()) {
		List<RelacionamentoWrapper> lisRel = classe.obtemListaComChaveEstrangeira();
		RelacionamentoWrapper rel1 = lisRel.get(0);
		RelacionamentoWrapper rel2 = lisRel.get(1);
	
    stringBuffer.append(TEXT_55);
    stringBuffer.append( rel1.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( rel2.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( rel1.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( rel1.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( rel2.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( rel2.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( rel1.getNomeRelacionamento() );
    stringBuffer.append( rel1.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( rel2.getNomeRelacionamento() );
    stringBuffer.append( rel2.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( rel2.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( rel2.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( rel1.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( rel1.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_70);
    
	} // final isAssociativa()
	
    stringBuffer.append(TEXT_71);
    
	if (!classe.isAssociativa()) {
	
    stringBuffer.append(TEXT_72);
    
		List<RelacionamentoWrapper> lisRel = classe.obtemListaDependentePai();
		for (RelacionamentoWrapper rel : lisRel) {
	
    stringBuffer.append(TEXT_73);
    stringBuffer.append( rel.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( rel.getClasseOposta().getNomeParaVariavel() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( rel.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( rel.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( rel.getClasseOposta().getNomeParaVariavel() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( rel.getClasseOposta().getNomeParaVariavel() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append( rel.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( rel.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( rel.getClasseOposta().getNomeParaVariavel() );
    stringBuffer.append(TEXT_82);
    
		}
	}
	
    stringBuffer.append(TEXT_83);
    
	if (classe.isAssociativa()) { 
		List<RelacionamentoWrapper> lisRel = classe.obtemListaComChaveEstrangeira();
		RelacionamentoWrapper rel1 = lisRel.get(0);
		RelacionamentoWrapper rel2 = lisRel.get(1);
	
    stringBuffer.append(TEXT_84);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( rel1.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( rel1.getNomeRelacionamento() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( rel2.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( rel2.getNomeRelacionamento() );
    stringBuffer.append(TEXT_90);
    
	} else {
	
    stringBuffer.append(TEXT_91);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_93);
    
	List<RelacionamentoWrapper> lisRel = classe.obtemListaDependentePai();
		for (RelacionamentoWrapper rel : lisRel) {
	
    stringBuffer.append(TEXT_94);
    stringBuffer.append( rel.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( rel.getNomeRelacionamento() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(  rel.getClasseOposta().getNomeParaVariavel() );
    stringBuffer.append(TEXT_97);
    
		}
	
    stringBuffer.append(TEXT_98);
    
	if (classe.obtemListaDependentePai().size()>0) {
	
    stringBuffer.append(TEXT_99);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_102);
    
		lisRel = classe.obtemListaDependentePai();
		for (RelacionamentoWrapper rel : lisRel) {
		
    stringBuffer.append(TEXT_103);
    stringBuffer.append( rel.getClasseOposta().getNomeParaVariavel() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( rel.getNomeRelacionamento() );
    stringBuffer.append( rel.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( rel.getClasseOposta().getNomeParaVariavel() );
    stringBuffer.append(TEXT_106);
    
		}
		
    stringBuffer.append(TEXT_107);
     } else { 
    stringBuffer.append(TEXT_108);
     //if (!classe.isAssociativa()) { 
    stringBuffer.append(TEXT_109);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_112);
     //} 
    stringBuffer.append(TEXT_113);
     } 
    stringBuffer.append(TEXT_114);
    
	}
	
    stringBuffer.append(TEXT_115);
    
	if (classe.isAssociativa()) { 
		List<RelacionamentoWrapper> lisRel = classe.obtemListaComChaveEstrangeira();
		RelacionamentoWrapper rel1 = lisRel.get(0);
		RelacionamentoWrapper rel2 = lisRel.get(1);
	
    stringBuffer.append(TEXT_116);
    stringBuffer.append( rel1.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( rel1.getClasseOposta().getNomeParaConstante() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( rel2.getClasseOposta().getNomeParaClasse() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( rel2.getClasseOposta().getNomeParaConstante() );
    stringBuffer.append(TEXT_120);
    
	}
	
    stringBuffer.append(TEXT_121);
    return stringBuffer.toString();
  }
}
