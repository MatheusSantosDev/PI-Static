package Pesquisa;

import Cad_Empresa.Cad_Empresa_dados;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class PesquisarDados {

    private String pesquisa;
    private ArrayList<Cad_Empresa_dados> estabelecimentos;

    public ArrayList<Cad_Empresa_dados> getEstabelecimentos() {
        return estabelecimentos;
    }

    public void setEstabelecimentos(ArrayList<Cad_Empresa_dados> estabelecimentos) {
        this.estabelecimentos = estabelecimentos;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    //Insere uma empresa na pesquisa
    public void addEstabelecimento(Cad_Empresa_dados c) {
        estabelecimentos.add(c);
    }

    public static String randomDigit() {
        int num = (int) (Math.random() * 10);
        return String.valueOf(num);
    }

    public String gerarCodigo(String nomeEstabelecimento) {
        StringBuilder str = new StringBuilder();
        char[] codigo = new char[4];
        for (int i = 0; i < 4; i++) {
            str.append(codigo[i] = nomeEstabelecimento.charAt(i));
        }
        for (int i = 0; i < 4; i++) {
            str.append(randomDigit());
        }

        return str.toString();
    }

}
