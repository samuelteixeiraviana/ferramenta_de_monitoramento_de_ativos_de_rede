# ferramenta_de_monitoramento_de_ativos_de_rede

O projeto visa criar um sistema web, utilizando Spring Boot, para monitorar a conectividade de dispositivos de rede em tempo real. A aplicação realiza pings periódicos para verificar se os equipamentos configurados estão "online" ou "offline".
Os pings são realizados com a classe InetAddress do Java, e o agendamento é configurado por meio da anotação @Scheduled, garantindo verificações automáticas em intervalos definidos. Os resultados são exibidos em uma interface web simples, criada com Thymeleaf, onde o status de cada dispositivo é apresentado em uma tabela.
O sistema é modular e permite a inclusão de novos dispositivos.
Este projeto é ideal para redes pequenas, fornecendo informações básicas de disponibilidade de forma acessível. No futuro, funcionalidades como envio de alertas, gráficos de desempenho e integração com APIs externas podem ser adicionadas para ampliar as capacidades do sistema.
A aplicação é uma solução prática e escalável para quem precisa de monitoramento simples, com potencial para crescimento conforme as necessidades aumentam.

# Histórias de usuário

Como administrador de rede, quero visualizar o status de todos os dispositivos monitorados em uma interface web, para acompanhar sua conectividade em tempo real.
Critérios de Aceitação:
-A interface deve exibir uma tabela com os endereços IP dos dispositivos e seu status (online/offline).
-O status deve ser atualizado automaticamente em intervalos regulares.

Como administrador de rede, quero adicionar ou remover dispositivos da lista monitorada, para gerenciar quais equipamentos estão sendo acompanhados.
Critérios de Aceitação:
-Deve haver uma interface ou arquivo de configuração para gerenciar a lista de dispositivos.
-A aplicação deve refletir as alterações sem necessidade de reiniciar.

Como administrador de rede, quero configurar o intervalo de tempo entre os pings, para ajustar o monitoramento conforme a necessidade.
Critérios de Aceitação:
-Deve haver uma configuração onde seja possível definir o intervalo (ex.: 5 segundos, 1 minuto, etc.).
-O intervalo configurado deve ser aplicado a todos os dispositivos monitorados.

Como administrador de rede, quero que o sistema suporte múltiplos usuários, para que outros membros da equipe possam acessar e usar a ferramenta.
Critérios de Aceitação:
-O sistema deve permitir autenticação de usuários com credenciais únicas.
-Diferentes níveis de acesso (ex.: leitura ou edição) devem ser configuráveis.
