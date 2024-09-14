public class Computador {
    String marca;
    float preco;

    SistemaOperacional sistemaOperacional;
    HardwareBasico[] hardwareBasico; //  3  x ItENS
    private MemoriaUSB memoriaUSB = new MemoriaUSB();


    public Computador(){ //constutor
        sistemaOperacional = new SistemaOperacional(); //para instanciar o sistema operacional dentro do computador
        hardwareBasico = new HardwareBasico[3];
    }

    private void sufixoHardwares(float capacidade){ //função para add os sufixos dos hardwares basicos e da memória USB
        if(capacidade > 1000) {
            System.out.println("Mhz");
        }
        else if (capacidade > 4) {
            System.out.println("Gb");
        }
        else{
            System.out.println("Tb");
        }
    }

    void mostraPCConfigs(){
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$" + preco);
        System.out.println("Hardware Básico:");

        //FOR EACH
        for (HardwareBasico hb : hardwareBasico){
            System.out.print(hb.nome + " Capacidade: " + hb.capacidade);
            sufixoHardwares(hb.capacidade); //chamando a função de sufixos
        }

        System.out.println("SO: " + sistemaOperacional.nome + " (" + sistemaOperacional.tipo + " bits)");
        if(!memoriaUSB.nome.isEmpty()){ //confirma se o meu nome não é vazio
            System.out.print("Acompanha " + memoriaUSB.nome + " de " + memoriaUSB.capacidade);
            sufixoHardwares(memoriaUSB.capacidade); //chamando a função de sufixos
        }
    }
    void addMemoriaUSB(MemoriaUSB musb){ //função/atritubutos
        this.memoriaUSB = musb;
    }

}