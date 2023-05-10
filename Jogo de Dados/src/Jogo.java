import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcao = 0;

        while (opcao!= 1 && opcao!=2){
            System.out.println("\nBEM VINDO AO JOGO DOS DADOS!");
            System.out.println("    1 - INICIAR");
            System.out.println("    2 - SAIR");
            opcao = entrada.nextInt();

            switch (opcao){
                case 1:
                    jogar(0, 0, 0);
                    break;
                case 2:
                    System.out.println("ESPERO TE VER NOVAMENTE. ATE LOGO!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }
    }

    public static void jogar(int pontos, int quantidadeJogos, int quantidadeVitorias){
        Scanner entrada = new Scanner(System.in);

        System.out.println("DIGITE UM NUMERO (DE 1 A 12):");
        int numero = entrada.nextInt();

        while (numero < 1 || numero > 12){
            System.out.println("O NUMERO DIGITADO ESTA FORA DO INTERVALO!");
            System.out.println("POR FAVOR, DIGITE UM NUMERO (DE 1 A 12):");
            numero = entrada.nextInt();
        }

        int resultado = compararNumeros(numero, gerarNumeroAleatorio());

        if(resultado !=0){
            quantidadeVitorias++;
        }

        quantidadeJogos++;

        pontos = pontos + resultado;

        continuar(pontos, quantidadeJogos, quantidadeVitorias);
    }

    public static int gerarNumeroAleatorio(){
        Random gerador = new Random();
        int numeroAleatorio = gerador.nextInt(12)+1;

        System.out.println("\nO NUMERO GERADO FOI " + numeroAleatorio);

        return numeroAleatorio;
    }

    public static int compararNumeros(int numeroUsuario, int numeroAleatorio){
        int pontos = 0;

        if(numeroUsuario == numeroAleatorio){
            pontos = 10;
            System.out.println("\nPARABENS! VOCE GANHOU 10 PONTOS");
        } else if(numeroUsuario == numeroAleatorio - 1 || numeroUsuario == numeroAleatorio + 1){
            pontos = 5;
            System.out.println("\nPASSOU PERTO! VOCE GANHOU 5 PONTOS");
        } else System.out.println("\nPOXA, VOCE ERROU. NENHUM PONTO PARA VOCE DESSA VEZ");

        return pontos;
    }

    public static void continuar(int pontos, int quantidadeJogos, int quantidadeVitorias){
        Scanner entrada = new Scanner(System.in);

        int opcao = 0;

        while (opcao!=3){
            System.out.println("\nO QUE DESEJA FAZER?");
            System.out.println("    1 - JOGAR NOVAMENTE");
            System.out.println("    2 - VER QUANTIDADE ATUAL DE PONTOS");
            System.out.println("    3 - VER RESULTADO FINAL E SAIR");
            opcao = entrada.nextInt();

            switch (opcao){
                case 1:
                    jogar(pontos, quantidadeJogos, quantidadeVitorias);
                    break;
                case 2:
                    System.out.println("A QUANTIDADE ATUAL DE PONTOS E " + pontos);
                    break;
                case 3:
                    System.out.println("--------RESULTADO FINAL--------");
                    System.out.println("TOTAL DE JOGOS - " + quantidadeJogos);
                    System.out.println("TOTAL DE ACERTOS - " + quantidadeVitorias);
                    System.out.println("TOTAL DE ERROS - " + (quantidadeJogos-quantidadeVitorias));
                    System.out.println("TOTAL DE PONTOS - " + pontos);
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }
    }
}
