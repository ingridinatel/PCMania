public class Cliente {
    String nome;
    long cpf;
    private float[][] carrinho = {
            {0,0}, //PC1{quantidade,valor}
            {0,0}, //PC2{quantidade,valor}
            {0,0} //PC3{quantidade,valor}
    };

    public void setCarrinho(int pc, float valor) {
        this.carrinho[pc][0] ++;  //ele vai adicionar na quantidade daquele PC
        this.carrinho[pc][1] = valor; //qual o valor do pc
    }

    public float[][] getCarrinho() {
        return carrinho;
    }

    float calculaTotalCompra(){
        float total = 0;
        for (int i = 0; i < 3; i++) {
            total = total + carrinho[i][0] * carrinho[i][1];
        }
        return total;
    }
}
