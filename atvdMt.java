import java.util.Scanner;

public class atvdMt {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        int vectorLength;
        int secondVectorLength;

        do {
            System.out.print("Informe uma quantidade de valores para o primeiro conjunto: ");
            vectorLength = scanner.nextInt(); // Faz uma leitura para o usuário informar a quantidade de posições no vetor
        } while ( vectorLength <= 0); // Verifica se a quantidade de índices do vetor não é negativa

        int firstGroup[] = new int[vectorLength]; // Insere a quantidade informada pelo usuário de posições, dentro do vetor

        for (int i = 0; i < firstGroup.length; i++) {
            System.out.println("Informe um valor para a " + ( i + 1 ) + " posição no conjunto: ");
            firstGroup[i] = scanner.nextInt();
        } // Faz uma varredura por todas as posições adicionando valores em cada uma

        do {
            System.out.println("Agora, informe um valor para o segundo conjunto: ");
            secondVectorLength = scanner.nextInt(); // Faz uma leitura para o usuário informar a quantidade de posições no vetor
        } while (secondVectorLength <= 0); // Verifica se a quantidade de índices do vetor não é negativa

        int secondGroup[] = new int[secondVectorLength]; // Insere a quantidade informada pelo usuário de posições, dentro do vetor

        for (int i = 0; i < secondGroup.length; i++) {
            System.out.println("Informe um valor para a " + (i + 1) + " posição no conjunto: ");
            secondGroup[i] = scanner.nextInt(); // Faz uma varredura por todas as posições adicionando valores em cada uma
        }

        // Printando na tela a união dos conjuntos
        int groupUnity[] = unity(firstGroup, secondGroup);
        System.out.println("A uniao do primeiro conjunto com o segundo conjunto é: ");
        printGroup(groupUnity);
        // Printando na tela a interseção dos conjuntos
        int groupIntersection[] = intersection(firstGroup, secondGroup);
        System.out.println("A intersecção do primeiro conjunto com o segundo conjunto é: ");
        printGroup(groupIntersection);
    }

    // Calculando a união dos conjuntos
    public static int[] unity(int [] firstGroup, int [] secondGroup) {
        // Verificando o tamanho máximo do conjunto
         int unitySize = firstGroup.length + secondGroup.length;
         int unity[] = new int[unitySize];
         int unityIndex = 0;

         // Adicionando os elementos do primeiro conjunto para a união
        for (int i = 0; i < firstGroup.length; i++) {
            if (!contains(unity, unitySize, firstGroup[i])) {
                unity[unityIndex] = firstGroup[i];
                unityIndex++;
            }
        }
        // Adicionando os elementos do segundo conjunto para a união
        for (int i = 0; i < secondGroup.length; i++) {
            if (!contains(unity, unitySize, secondGroup[i])) {
                unity[unityIndex] = secondGroup[i];
                unityIndex++;
            }
        }
        return resize(unity, unityIndex);
    }

    // Metodo para calcular a interseção dos conjuntos
    public static int[] intersection(int firstGroup[], int secondGroup[]) {
        int[] tempIntersection = new int[Math.min(firstGroup.length, secondGroup.length)];
        int intersectionIndex = 0;

        // Verificando quais elementos de A estão em B
        for (int i = 0; i < firstGroup.length; i++) {
            if (contains(secondGroup, secondGroup.length, firstGroup[i]) && !contains(tempIntersection, intersectionIndex, firstGroup[i])) {
                tempIntersection[intersectionIndex] = firstGroup[i];
                intersectionIndex++;
            }
        }
        // Redimensionando a interseção para o tamanho corretor
        return resize(tempIntersection, intersectionIndex);
    }

    // Método para printar na tela o conjunto
    public static void printGroup(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Método para redimensionar o conjunto para um tamanho específico
    public static int[] resize(int array[], int newSize) {
        int[] newArray = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    // Método que verifica se o número já existe no conjunto
    public static boolean contains(int array[], int length, int element) {
        for (int i = 0; i < length; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }
}
