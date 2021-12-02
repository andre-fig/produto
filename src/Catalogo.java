public class Catalogo {

    Produto[] tabela = new Produto[10];
    char[] flag = new char[10];
    int qtde;
    String codTH;
    String pais;

    Catalogo() {
        for (int i = 0; i < tabela.length; i++) {
            flag[i] = 'L';
        }
        qtde = 0;
    }

    int funcaoHash(String cod) {
        //considerar apenas três primeiros caracteres do código de produto
        codTH = cod.substring(0, 3);
        int soma = 0;
        for (int i = 0; i < cod.length(); i++) {
            soma += (int) cod.charAt(i);
        }
        return soma % tabela.length;
    }

    void mostrarTH() {
        for (int i = 0; i < tabela.length; i++) {
            if (flag[i] == 'O') {
                System.out.print("\nEntrada " + i + ": " + tabela[i].getCodigo() + " - " + tabela[i].getDescricao() + " - " + tabela[i].getPreco());
            }
        }
    }


    void inserirTH(int pos, Produto n) {
        if (flag[pos] == 'L' || flag[pos] == 'R') {
            tabela[pos] = n;
            flag[pos] = 'O';

        } else {
            int i = pos + 1;
            if (i == tabela.length) {
                i = 0;
            }
            while (true) {
                if (flag[i] != 'O') {
                    tabela[i] = n;
                    flag[i] = 'O';
                    break;
                } else {
                    i++;
                    if (i == tabela.length) {
                        pos = 0;
                    }
                }
            }
            
        }
        System.out.println("\nProduto inserido com sucesso!");
        qtde++;

    }

    String buscarPais(String g){
        if (g.equals("789") || g.equals("790")){
            pais = "Brasil";}
        return pais;
    }

    int buscarTH(String n) {
        int i = 0;
        int pos = funcaoHash(n);
        
        if (tabela[pos].getCodigo().equals(n)){
            return pos;
        }
        else {
            i = pos + 1;
            if (i==tabela.length)
                    i = 0;
            while (true){
                if (flag[i] != 'O' || i==pos){
                    pos = tabela.length;
                    break;
                }
                if (tabela[i].getCodigo().equals(n)){
                    pos = i;
                    break;
                }
                i++;
                if (i==tabela.length)
                    i = 0;           
            }
            return pos;
        }      
    }

    void remover(String n) {
        int posicao = buscarTH(n);

        if (posicao < tabela.length) {
            flag[posicao] = 'R';
            System.out.println("\nProduto EXCLUÍDO com sucesso!");
            qtde--;
        } else {
            System.out.println("\nProduto não está presente!!");
        }
    }
}
