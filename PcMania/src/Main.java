import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        float matricula = 121;
        String[] marcas = {"Positivo", "Acer", "Vaio"}; //Lista
        float[] precos = {matricula, matricula+1234, matricula+5678};
        String[][] nomeHardware = {
                {"Pentium Core i3", "Memória RAM", "HD"}, //PC1
                {"Pentium Core i5", "Memória RAM", "HD"}, //PC2
                {"Pentium Core i7", "Memória RAM", "HD"},  //PC3
        };

        int[][] capacidadeHardware = {
                {2200, 8, 500}, //PC1
                {3370, 16, 1},  //PC2
                {4500, 32, 2}, //PC3
        };

        String[] nomeSistemaOp = {"Linux Ubunto", "Windows 8", "Windows 10"};
        int[] capacidadeSistemaOp = {32, 64, 64};

        String[] nomeMemoriaUSB = {"Pendrive", "Pendrive", "HD Externo"};
        int[] capacidadeMemoriaUSB = {16, 32, 1};

        Cliente cliente = new Cliente();

        Computador[] computadores = new Computador[3]; // lista de computadores com as três promoções
        for (int i = 0; i < 3; i++) { //for para definirmos todas as informações dos computadores
            computadores[i] = new Computador(); //instanciando a classe computador na posição i
            computadores[i].marca = marcas[i];
            computadores[i].preco = precos[i];
            for (int j = 0; j < 3; j++) { //utilizado para definir os hardwares básicos de cada pc
                computadores[i].hardwareBasico[j] = new HardwareBasico(); //instanciar o HB na posição j do pc na posição i
                computadores[i].hardwareBasico[j].nome = nomeHardware[i][j];
                computadores[i].hardwareBasico[j].capacidade = capacidadeHardware[i][j];
            }
            computadores[i].sistemaOperacional = new SistemaOperacional();
            computadores[i].sistemaOperacional.nome = nomeSistemaOp[i];
            computadores[i].sistemaOperacional.tipo = capacidadeSistemaOp[i];

            MemoriaUSB memoriaUSB = new MemoriaUSB();
            memoriaUSB.nome = nomeMemoriaUSB[i];
            memoriaUSB.capacidade = capacidadeMemoriaUSB[i];

            computadores[i].addMemoriaUSB(memoriaUSB); //adicionei a memória USB dentro do computador
        }

        //Para ler do teclado a posicao digitada
        Scanner entrada = new Scanner(System.in);
        int entradaPromocao;
        System.out.println("Digite seu nome: ");
        cliente.nome = entrada.next();
        System.out.println("Digite seu CPF: ");
        cliente.cpf =entrada.nextLong();
        while(true){  //enquanto for verdadeiro ele roda, nesse caso para sempre
            System.out.println("Qual PC você deseja comprar?");
            System.out.println("1- Promoção 1");
            System.out.println("2- Promoção 2");
            System.out.println("3- Promoção 3");
            System.out.println("0- Sair");
            entradaPromocao = entrada.nextInt();

            if(entradaPromocao > 0 && entradaPromocao < 4){
                System.out.println("Inserido no carrinho o computador da promoção " + entradaPromocao);
                cliente.setCarrinho(entradaPromocao - 1, computadores[entradaPromocao-1].preco);
            }
            else if(entradaPromocao == 0){
                break;
            }
            else {
                System.out.println("Opção Inválida!");
            }
        }
        System.out.println("Caro clinete " + cliente.nome + " portador do CPF " + cliente.cpf + " segue abaixo o resumo da sua compra: ");
        System.out.println("Valor total da sua compra foi de:R$ " + cliente.calculaTotalCompra());
        System.out.println("Segue abaixo as quantidades e configurações dos computadores comprados:");
        int i = 0;
        for (float[] computador : cliente.getCarrinho()){
            i++;
            if(computador[0] > 0){
                System.out.println("Foram comprados " + computador[0] + " unidades do computador da promoção " + i + " com a configuração abaixo: ");
                computadores[i-1].mostraPCConfigs();
            }
        }

    }
}