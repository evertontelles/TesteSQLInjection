#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Algoritmo_Consumo_total

int main()
{
    float consumo_mes, custo_kwh;  // recebe consumo em kw no mês, custo em reais kw, horas de uso no dia
    int lampada, chuveiro, freezer, geladeira;  // recebe valores de consumo por mes em numeros inteiros

    lampada = 120 * 5 * 30;
    chuveiro = 3000 * 1 * 30;
    freezer = 200 * 24 * 30;
    geladeira = 250 * 24 * 30;
    custo_kwh = 0.3;

    consumo_mes = ((lampada + chuveiro + freezer + geladeira) * custo_kwh);

    printf ("consumo total: %f", consumo_mes);


    return 0;
}
/* 5400
27000
43200
54000
*/
