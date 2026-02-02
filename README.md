Jogo de turnos realizado como entrega da segunda unidade do curso de Programação Orientada a Objetos, ministrado pelo professor Dr. André Yoshiaki Kashiwabara, na Universidade Federal de Sergipe.

Grupo: Kaick Tauil Gallotte

Especificações do projeto:

    1- As classes tanque, mago e atirador foram adaptadas para o universo de Star Wars, no qual o jogo se baseia, mantendo seu conceito original, porém com as nomeclaturas:
        - Tanque -> Wookie;
        - Mago -> Jedi;
        - Atirador -> Clone
    
    2- O jogo deve ser executado a partir da classe main

    3- O projeto foi feito utilizando as seguintes dependencias:
        - Java 25.0.1
        - JUnit 6.0.2
        - Mockito 5.7.0

    4- Foi utilizada IA para codificação bruta dos testes, para otimizar o tabalho repetitivo de escrita, porém todos os testes foram revisados e adaptado conforme necessidade


Jogabilidade:

    1- Nesta primeira versão, apenas a classe Jedi (mago) possui uma habilidade ativa - ou seja, que pode ser utilizada ativamente pelo jogador -, os demais contam com habilidades passivas (são ativadas de acordo com determinadas condições)

    2- Habilidades dos personagens:
        - Jedi:
            * Force Push - desfere um empurrão utilizando a Força, causando 2,5 vezes o dano de ataque do usuário por um custo de 20 de mana;

        - Wookie: 
            * Vitality - usuários da categoria wookie possui o atributo "vigor", o qual serve como uma espécie de escudo. Ao receber um ataque, usuário dessa habilidade consome todo o seu vigor para curá-lo previamente, reduzindo indiretamente o dano de ataque recebido. Essa habilidade só é ativada uma vez.

        - Clone:
            * Headshot - clones tem 45% de chance de causar um acerto crítico ao atacar, o dano do acerto crítico é calculado somando o ataque do usuário ao seu atributo de dano crítico percentual.

Documentação:

    1- CRC Cards: https://starbattle-crc-cards.my.canva.site/