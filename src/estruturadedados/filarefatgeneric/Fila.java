package estruturadedados.filarefatgeneric;
//refatorada para embutir a adicao de nó direto em metodo da classe Fila
import java.util.ArrayList;
import java.util.List;
//SERÁ POSSÍVEL SOMENTE UM TIPO DE DADO
public class Fila<T> {

    private No<T> refNoEntradaFila;

    public Fila(){
        this.refNoEntradaFila = null;
    } 

    public boolean isEmpty(){
        return refNoEntradaFila == null? true: false;
    }

    public void enqueue(T object) {
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    public T first(){ //pega o primeiro nó
        if (!isEmpty()){
            No primeiroNo = refNoEntradaFila;

            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    break;
                }
            }
            return (T) primeiroNo.getObject();
            //vai retornar somente o conteudo desse nó
        } else {
            return null;
        }
    }

    public T dequeue() { //retorna o primeiro nó, que foi retirado
        No primeiroNo = refNoEntradaFila;
        No noAuxiliar = refNoEntradaFila;

        if (!isEmpty()){
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        } else {
            return null;
        }
    }

    public List multDequeue(int qtdeVezes) {
        if (!isEmpty()){    
            List<T> nosRetirados = new ArrayList<>();

            for (int i = 0; i< qtdeVezes; i++){
                T noRetirado = this.dequeue();
                nosRetirados.add(noRetirado);
            }

            return nosRetirados;
        } else {
            return null;
        }
    }

    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if (refNoEntradaFila != null) {
            while (true) {
                stringRetorno += "[No{Objeto=" + noAuxiliar.getObject() + "}] --->";
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    //quando chega no primeiro nó da fila diz que ele aponta para nulo;
                    stringRetorno += "null";
                    break;
                }
            } 
            return stringRetorno;
        } else {
            return null;
        }
    }
}
