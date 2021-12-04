import java.util.*;

public class ProjProduto {

    public static void main(String[] args) {
        int op, pos;

        Scanner ent = new Scanner(System.in);

        //É a classe que tem a hash table
        Catalogo catalogo = new Catalogo();

        String codigo = null;
        String descricao;
        int verificaDescricao;
        Double preco = null;
        String pais;

        do {
            System.out.println("\nMenu de opções\n");
            System.out.println("1- Inserir elemento");
            System.out.println("2- Mostrar Tabela Hash");
            System.out.println("3- Excluir elemento");
            System.out.println("4- Buscar país");
            System.out.println("5- Consultar elemento");
            System.out.println("6- Sair");
            System.out.println("\nDigite a sua opção: ");
            op = ent.nextInt();

            if (op < 1 || op > 6) {
                System.out.println("\nOpção inválida!");
            } else {
                switch (op) {

                    case 1:

                        if (catalogo.qtde == catalogo.tabela.length) {
                            System.out.println("Tabela Cheia!!");
                        } else {

                            System.out.print("Informe o código do produto: ");
                            codigo = ent.next();

                            while(codigo.length() != 13){
                                System.out.println("Código inválido! Digite o código novamente: ");
                                codigo = ent.next();
                            }

                            ent.nextLine();

                            System.out.print("Digite a descrição do Produto: ");
                            descricao = ent.nextLine();

                            //Verifica descrição, que não pode estar em branco
                            //Deve haver medida para não tolerar o caractere de espaço
                            verificaDescricao = descricao.replace(" ", "").length();
                            while (verificaDescricao == 0) {
                                System.out.println("Descrição inválida! Informe novamente: ");
                                descricao = ent.nextLine();
                                verificaDescricao = descricao.replace(" ", "").length();
                            }


                            // Preço deve ser maior que 0
                            System.out.println("Digite o preço do produto:");
                            preco = ent.nextDouble();
                            while (preco <= 0) {
                                System.out.println("Preço inválido! Digite novamente: ");
                                preco = ent.nextDouble();
                            }

                            //calcula a posição na TH
                            pos = catalogo.funcaoHash(codigo);

                            catalogo.inserirTH(pos, new Produto(codigo, descricao, preco));
                        }
                        break;

                    case 2:
                        catalogo.mostrarTH();
                        break;

                    case 3:
                        System.out.print("\nDigite o Código do Produto para exclusão: ");
                        codigo = ent.next();
                        codigo = codigo.toUpperCase();
                        catalogo.remover(codigo);
                        break;

                        // imprime o país do produto
                    case 4:
                        System.out.print("\nDigite o Código de Produto para buscar o país: ");
                        codigo = ent.next();
                        codigo = codigo.toUpperCase();
                        pos = catalogo.buscarTH(codigo);
                        if (pos == catalogo.tabela.length) {
                            System.out.println("\nProduto NÃO existe na tabela!");
                        } else {
                            String codPais = codigo.substring(0, 3);
                            pais = catalogo.buscarPais(codPais);
                            System.out.println("\n O país do produto é "+ pais);
                        }
                        break;

                    case 5:
                        System.out.print("\nDigite o Código de Produto para pesquisa: ");
                        codigo = ent.next();
                        codigo = codigo.toUpperCase();
                        pos = catalogo.buscarTH(codigo);
                        if (pos == catalogo.tabela.length) {
                            System.out.println("\nProduto NÃO existe na tabela!");
                        } else {
                            System.out.println("\nProduto EXISTE na tabela na posição " + pos);
                        }
                        break;

                }
            }
        } while (op != 6);
    }

}
