package avaliacao2;

import java.util.*;
import java.io.*;

public class avaliacao2 {

    public static Boolean loop = false;
    public static Scanner input = new Scanner(System.in);
    public static int nroCandidato = 0;
    public static String nomeCandidato = "";
    public static String localVotacao = "";
    public static Formatter arquivo;
    public static File dirCandidatos = new File(System.getProperty("user.dir"), "candidatos");
    public static File dirLocais = new File(System.getProperty("user.dir"), "locais");
    public static Scanner arquivoLocal;
    public static Scanner arquivoCandidato;

    // Hashmap para ordenar os candidatos por votos.
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {

        // Criar pastas
        if (!dirCandidatos.exists()) {
            dirCandidatos.mkdir();
        }
        if (!dirLocais.exists()) {
            dirLocais.mkdir();
        }

        // Menu de Opçoes
        while (true) {
            System.out.print("\n\n----------- Eleiçoes -----------");
            System.out.print("\n--------------------------------");
            System.out.print("\n1 - Inserir candidato");
            System.out.print("\n2 - Listar candidatos");
            System.out.print("\n3 - Criar local de votaçao");
            System.out.print("\n4 - Listar eleitores de local de votaçao");
            System.out.print("\n5 - Buscar local de votaçao do eleitor");
            System.out.print("\n6 - Votar");
            System.out.print("\n7 - Encerrar votaçao");
            System.out.print("\n-----------------------------");

            Boolean done = false;
            int opcao = 0;

            while (!done) {
                try {
                    System.out.print("\nOpcao: ");
                    input = new Scanner(System.in);
                    opcao = input.nextInt();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.print("Formato errado, tente novamente.");
                }
            }

            switch (opcao) {
                case 1:
                    inserirCandidato();
                    break;

                case 2:
                    listarCandidatos();
                    break;

                case 3:
                    criarLocal();
                    break;

                case 4:
                    listarEleitores();
                    break;

                case 5:
                    buscarEleitor();
                    break;

                case 6:
                    votar();
                    break;

                case 7:
                    encerrarVotacao();
                    System.out.println("\nEncerrando o programa...\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcao errada, selecione outra opcao.\n");
                    break;
            }

        }

    }

    // Inserir Candidato
    static void inserirCandidato() {
        loop = false;
        while (!loop) {
            try {
                System.out.println("Numero do Candidato: ");
                input = new Scanner(System.in);
                nroCandidato = input.nextInt();
                loop = true;
            } catch (InputMismatchException e) {
                System.out.print("Formato errado, tente novamente.");
            }
        }
        System.out.println("Nome do Candidato: ");
        input = new Scanner(System.in);
        nomeCandidato = input.nextLine();
        String nomeArquivo = nroCandidato + " - " + nomeCandidato;
        File candidatoFile = new File(dirCandidatos, nomeArquivo);
        candidatoFile.toString();
        if (!candidatoFile.exists()) {
            try {
                arquivo = new Formatter(candidatoFile);
            } catch (SecurityException sec) {
                System.err.println("Sem permissao");
                System.exit(1);
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao abrir o arquivo");
                System.exit(1);
            }
        } else {
            System.out.println("\nCandidato já registrado");
        }
    }

    // Listar Candidatos
    static void listarCandidatos() {
        String[] candidatos = dirCandidatos.list();
        for (int i = 0; i < candidatos.length; i++) {
            String dadosCand[] = candidatos[i].split(" - ");
            System.out.print("Candidato: " + dadosCand[1] + ", N° " + dadosCand[0]);
        }
    }

    // Inserir Local e Eleitores
    static void criarLocal() {

        // Criar local de votaçao
        System.out.println("Nome do Local de Votaçao: ");
        input = new Scanner(System.in);
        localVotacao = input.nextLine();
        File localFile = new File(dirLocais, localVotacao);
        if (!localFile.exists()) {
            try {
                arquivo = new Formatter(localFile);
            } catch (SecurityException sec) {
                System.err.println("Sem permissao");
                System.exit(1);
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao abrir o arquivo");
                System.exit(1);
            }
        } else {
            System.out.println("\nLocal já registrado");
        }
        System.out.println("Local de votaçao registrado.");
        // Inserir eleitores no local
        System.out.println("Inserir eleitores. (Digite 'Sair' quando acabar de registrar os eleitores).");
        loop = false;
        while (!loop) {
            System.out.println("Nome e Sobrenome do eleitor: ");
            input = new Scanner(System.in);
            String nomeEleitor = input.nextLine();
            if (nomeEleitor.equals("Sair") || nomeEleitor.equals("sair")) {
                System.out.println("Fechando registro de eleitores...");
                loop = true;
                arquivo.close();
            } else {
                // Registrar dados no arquivo do local
                nomeEleitor = nomeEleitor.replace(" ", "-");
                try {
                    arquivo.format("%s %n", nomeEleitor);
                } catch (FormatterClosedException f) {
                    System.err.println("Erro ao escrever");
                    break;
                } catch (NoSuchElementException e) {
                    System.err.println("Valor inválido");
                    input.nextLine();
                }
            }
        }
    }

    // Listar eleitores
    static void listarEleitores() {
        System.out.println("Nome do local: ");
        input = new Scanner(System.in);
        String nomeLocal = input.nextLine();
        File localFile = new File(dirLocais, nomeLocal);
        if (!localFile.exists()) {
            System.out.println("Local nao registrado.");
        } else {
            try {
                arquivoLocal = new Scanner(localFile);
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao abrir o arquivo");
                System.exit(1);
            }
            try {
                while (arquivoLocal.hasNext()) {
                    System.out.printf("%s %n", arquivoLocal.next().replace("-", " "));
                }
            } catch (NoSuchElementException e) {
                System.err.println("Formataçao do arquivo incompativel");
            } catch (IllegalStateException e) {
                System.err.println("Erro na leitura do arquivo");
            }
        }
    }

    // Buscar eleitor
    static void buscarEleitor() {
        System.out.println("Nome do eleitor: ");
        input = new Scanner(System.in);
        String nomeEleitor = input.nextLine();
        nomeEleitor = nomeEleitor.replace(" ", "-");
        String[] locais = dirLocais.list();
        Boolean achado = false;
        for (int i = 0; i < locais.length; i++) {
            File localFile = new File(dirLocais, locais[i]);
            try {
                arquivoLocal = new Scanner(localFile);
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao abrir o arquivo");
                System.exit(1);
            }
            try {
                while (arquivoLocal.hasNext()) {
                    String lineFromFile = arquivoLocal.next();
                    if (lineFromFile.contains(nomeEleitor)) {
                        System.out.println("O eleitor vota no local: " + locais[i]);
                        achado = true;
                        break;
                    }
                }
            } catch (NoSuchElementException e) {
                System.err.println("Formataçao do arquivo incompativel");
            } catch (IllegalStateException e) {
                System.err.println("Erro na leitura do arquivo");
            }
        }
        if (!achado) {
            System.out.println("Nao foi possivel encontrar o eleitor.");
        }
    }

    // Votar
    static void votar() {
        System.out.println("Nome do eleitor: ");
        input = new Scanner(System.in);
        String nomeEleitor = input.nextLine();
        System.out.println("Numero do candidato: ");
        input = new Scanner(System.in);
        int nroCandidato = input.nextInt();
        // procurar eleitor
        nomeEleitor = nomeEleitor.replace(" ", "-");
        String[] locais = dirLocais.list();
        Boolean achado = false;
        for (int i = 0; i < locais.length; i++) {
            File localFile = new File(dirLocais, locais[i]);
            try {
                arquivoLocal = new Scanner(localFile);
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao abrir o arquivo");
                System.exit(1);
            }
            try {
                while (arquivoLocal.hasNext()) {
                    String lineFromFile = arquivoLocal.next();
                    if (lineFromFile.contains(nomeEleitor)) {
                        achado = true;
                        break;
                    }
                }
            } catch (NoSuchElementException e) {
                System.err.println("Formataçao do arquivo incompativel");
            } catch (IllegalStateException e) {
                System.err.println("Erro na leitura do arquivo");
            }
        }
        if (!achado) {
            System.out.println("Nao foi possivel encontrar o eleitor.");
        }
        // Procurar candidato
        String[] candidatos = dirCandidatos.list();
        achado = false;
        for (int i = 0; i < candidatos.length; i++) {
            String[] dadosCand = candidatos[i].split(" - ");
            if (String.valueOf(nroCandidato).equals(dadosCand[0])) {
                // Registrar voto
                File candidatoFile = new File(dirCandidatos, candidatos[i]);
                try {
                    FileWriter atualizar = new FileWriter(candidatoFile, true);
                    atualizar.write("1");
                    atualizar.close();
                    System.out.println("Voto realizado.");
                } catch (SecurityException sec) {
                    System.err.println("Sem permissao");
                    System.exit(1);
                } catch (FileNotFoundException e) {
                    System.err.println("Erro ao abrir o arquivo");
                    System.exit(1);
                } catch (IOException e) {
                    System.err.println("Erro ao atualizar arquivo");
                    System.exit(1);
                }
                achado = true;
                break;
            }
        }
        if (!achado) {
            System.out.println("Nao foi possivel encontrar o candidato.");
        }
    }

    // Encerrar Votaçao
    static void encerrarVotacao() {
        // Total de Eleitores
        int totalEleitores = 0;
        String[] locais = dirLocais.list();
        for (int i = 0; i < locais.length; i++) {
            File localFile = new File(dirLocais, locais[i]);
            try {
                arquivoLocal = new Scanner(localFile);
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao abrir o arquivo");
                System.exit(1);
            }
            try {
                while (arquivoLocal.hasNextLine()) {
                    arquivoLocal.nextLine();
                    totalEleitores++;
                }
            } catch (NoSuchElementException e) {
                System.err.println("Formataçao do arquivo incompativel");
            } catch (IllegalStateException e) {
                System.err.println("Erro na leitura do arquivo");
            }
        }
        System.out.println("\nNumero de eleitores: " + totalEleitores);
        // Total de Votos
        int totalVotos = 0;
        String[] candidatos = dirCandidatos.list();
        for (int i = 0; i < candidatos.length; i++) {
            File localFile = new File(dirCandidatos, candidatos[i]);
            try {
                arquivoLocal = new Scanner(localFile);
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao abrir o arquivo");
                System.exit(1);
            }
            try {
                String linea = arquivoLocal.nextLine();
                totalVotos = totalVotos + linea.length();
            } catch (NoSuchElementException e) {
                System.err.println("Formataçao do arquivo incompativel");
            } catch (IllegalStateException e) {
                System.err.println("Erro na leitura do arquivo");
            }
        }
        System.out.println("Total de Votos: " + totalVotos);
        // Porcentagem de Abstençao
        double abstencao = 0.00, aux = 0.00;
        aux = (100 / totalEleitores) * totalVotos;
        abstencao = (100 - aux);
        System.out.println("Abstençoes: " + abstencao);
        // Ler e ordenar os candidatos por votos
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < candidatos.length; i++) {
            int votos = 0;
            String dadosCand[] = candidatos[i].split(" - ");
            File localFile = new File(dirCandidatos, candidatos[i]);
            try {
                arquivoLocal = new Scanner(localFile);
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao abrir o arquivo");
                System.exit(1);
            }
            try {
                String linea = arquivoLocal.nextLine();
                votos = linea.length();
            } catch (NoSuchElementException e) {
                System.err.println("Formataçao do arquivo incompativel");
            } catch (IllegalStateException e) {
                System.err.println("Erro na leitura do arquivo");
            }
            hm.put(dadosCand[1], votos);
        }
        Map<String, Integer> hm1 = sortByValue(hm);
        int contador = candidatos.length;
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println(contador + "° Colocado: " + en.getKey() + " com " + ((100 / totalVotos) * en.getValue())
                    + "% de votos.");
            contador--;
        }
    }

}