package TicTacToe.model;

import TicTacToe.entities.enums.XorO;

public class TikTakToe {

    private static Integer n;

    private static XorO[][] tabuleiro;

    private static Jogador jogador1;

    private static Jogador jogador2;


    public TikTakToe(Integer n) {
        TikTakToe.n = n;
        TikTakToe.tabuleiro = new XorO[n][n];
        popularTabuleiroInicial();
    }

    public static void popularTabuleiroInicial() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tabuleiro[i][j] = XorO.TYPE_BLANK;
            }
        }
    }

    public static boolean verificaGanhador() {
        int countj1 = 0;
        int countj2 = 0;
        /*
        loops que testam as linhas
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tabuleiro[i][j].getDescricao().equalsIgnoreCase(jogador1.getXo().toString())) {
                    countj1++;
                }
                if (tabuleiro[i][j].getDescricao().equalsIgnoreCase(jogador2.getXo().toString())) {
                    countj2++;
                }
            }
            if ((countj1 == n) || (countj2 == n)) {
                return true;
            } else {
                countj1 = 0;
                countj2 = 0;
            }
        }
        /*
        loops que testam as colunas
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tabuleiro[j][i].getDescricao().equalsIgnoreCase(jogador1.getXo().toString())) {
                    countj1++;
                }
                if (tabuleiro[j][i].getDescricao().equalsIgnoreCase(jogador2.getXo().toString())) {
                    countj2++;
                }
            }
            if ((countj1 == n) || (countj2 == n)) {
                return true;
            } else {
                countj1 = 0;
                countj2 = 0;
            }
        }
        /*
        loops que testam as verticais
         */
        for (int j = 0; j < n; j++) {
            if (tabuleiro[j][j].getDescricao().equalsIgnoreCase(jogador1.getXo().toString())) {
                countj1++;
            }
            if (tabuleiro[j][j].getDescricao().equalsIgnoreCase(jogador2.getXo().toString())) {
                countj2++;
            }
        }
        for (int j = n-1; j >= 0; j--) {
            if (tabuleiro[j][j].getDescricao().equalsIgnoreCase(jogador1.getXo().toString())) {
                countj1++;
            }
            if (tabuleiro[j][j].getDescricao().equalsIgnoreCase(jogador2.getXo().toString())) {
                countj2++;
            }
        }
        if ((countj1 == (2 * n)) || (countj2 == (2 * n))) {
            return true;
        }
        return false;
    }

    /**
     * Metodo que preenche uma posicao especifica da matrix com o valor indicado
     *
     * @param x
     * @param y
     * @param valor
     * @return
     */
    public static boolean realizaJogada(Integer x, Integer y, String valor) {
        if (tabuleiro[x-1][y-1] != XorO.TYPE_BLANK) {
            return false;
        } else {
            XorO[][] tab = tabuleiro;
            tab[x - 1][y - 1] = validaValor(valor);
        }
        return true;
    }

    /**
     * Metodo que valida se o valor inserido é um valor valido
     *
     * @param valor
     * @return XorO
     */
    public static XorO validaValor(String valor) {
        if (valor.equalsIgnoreCase("x")) {
            return XorO.X;
        } else if (valor.equalsIgnoreCase("o")) {
            return XorO.O;
        } else {
            System.out.println("Caracter invalido, tente novamente");
            return XorO.TYPE_BLANK;
        }
    }

    public static Jogador getJogador1() {
        return jogador1;
    }

    public static void setJogador1(Jogador jogador1) {
        TikTakToe.jogador1 = jogador1;
    }

    public static Jogador getJogador2() {
        return jogador2;
    }

    public static void setJogador2(Jogador jogador2) {
        TikTakToe.jogador2 = jogador2;
    }

    @Override
    public String toString() {
        String statusTabuleiro = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                statusTabuleiro += tabuleiro[i][j].getDescricao();
                if (j < n - 1) {
                    statusTabuleiro += " | ";
                }
            }
            statusTabuleiro += " \n";
        }
        return statusTabuleiro;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        TikTakToe.n = n;
    }

    public static XorO[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(XorO[][] tabuleiro) {
        TikTakToe.tabuleiro = tabuleiro;
    }


}
