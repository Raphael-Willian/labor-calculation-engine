# LABOR-CALCULATION-ENGINE

## Objetivo do Projeto

Esse projeto tem como objetivo principal, ser uma engine de cálculos trabalhistas para sistemas terceiros. Utilizando do protocolo HTTP como protocolo base de comunicação.

## Atividades que a API Executará
#### Inicialmente:
* Horas Extras: Acréscimo de no mínimo 50% sobre o valor da hora normal para as horas trabalhadas além da jornada legal.
* Adicional Noturno: Acréscimo de 20% sobre a hora diurna para o trabalho realizado entre as 22h de um dia e as 5h do dia seguinte (na área urbana).
* Férias + 1/3 Constitucional: Remuneração de 30 dias de descanso acrescida de um terço do valor do salário.
* 13º Salário: Gratificação salarial paga em duas parcelas, calculada proporcionalmente aos meses trabalhados no ano (1/12 por mês).
* DSR (Descanso Semanal Remunerado): Valor devido pelo dia de descanso obrigatório, que também reflete o recebimento de comissões e horas extras.

## Leis de Embasamento para o Projeto
#### Horas Extras:
* Constituição Federal (CF/88): Art. 7º, Inciso XVI — Garante a remuneração do serviço extraordinário superior, no mínimo, em 50% à do normal.
* CLT (Consolidação das Leis do Trabalho): Art. 59, § 1º — Determina que a hora extra seja paga com o acréscimo mínimo de 50% sobre o valor da hora normal.

#### Adicional Noturno:
* Constituição Federal (CF/88): Art. 7º, Inciso IX — Estabelece que a remuneração do trabalho noturno deve ser superior à do diurno.
* CLT (Consolidação das Leis do Trabalho): Art. 73, caput e § 2º — Fixa o adicional mínimo de 20% sobre a hora diurna e define a jornada urbana noturna das 22h às 5h (ressaltando o § 1º, que estabelece a hora reduzida de 52 minutos e 30 segundos).

#### Férias + 1/3 Constitucional:
* Constituição Federal (CF/88): Art. 7º, Inciso XVII — Assegura o gozo de férias anuais remuneradas com, pelo menos, um terço a mais do que o salário normal.
* CLT (Consolidação das Leis do Trabalho): Arts. 129 a 145 — Regulamentam o direito ao período aquisitivo e concessivo de férias, sendo o Art. 130 responsável por fixar o direito a até 30 dias corridos e o Art. 142 por tratar do cálculo da remuneração.

#### DSR (Descanso Semanal Remunerado):
* Constituição Federal (CF/88): Art. 7º, Inciso XV — Assegura o direito ao repouso semanal remunerado, preferencialmente aos domingos.
* Lei nº 605/1949: Art. 1º — Regulamenta especificamente o DSR, garantindo o repouso de 24 horas consecutivas, bem como a remuneração nos feriados civis e religiosos.
* CLT (Consolidação das Leis do Trabalho): Art. 67 — Reitera a garantia do descanso de 24 horas consecutivas a todo empregado, prevendo a coincidência obrigatória com o domingo, salvo exceções de conveniência pública ou necessidade do serviço.

## Escopo Inicial o Projeto
* Java 21
* Maven (Como Gerenciador de Dependências)
* Spring Framework v4.1.1
* Docker
* Redis
* PostgreSQL