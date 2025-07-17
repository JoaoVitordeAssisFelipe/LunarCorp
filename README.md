<h1>🚀 Projeto: LunarCorp - Sistema de Chamados Técnicos</h1>

E uma aplicação web desenvolvida em Java com Spring Boot, com foco na gestão de chamados técnicos entre usuários e profissionais de suporte. 
O sistema permite que usuários comuniquem problemas e que técnicos recebam, acompanhem e finalizem atendimentos. 
O projeto tem intuito de demonstrar meu conhecimentos sobre APIs REST, boas práticas de modelagem de dados e tratamento de exceções.

<h2>⚙️ Funcionalidades Implementadas</h2>
<li>Criação de chamados</li>
<li>Usuário seleciona técnico destinatário, informa a natureza do problema e descrição.</li>
<li>Backend salva o chamado com status inicial ABERTO e registra a data atual.</li>
<li>Relacionamento entre entidades</li>
<li>Técnicos herdam atributos de usuários (herança via JPA).</li>
<li>Chamados possuem referência ao solicitante e ao destinatário técnico.</li>
<li>Enum para categorização de chamados</li>
<li>Natureza dos chamados é representada por um Enum, como HARDWARE_E_PERIFERICO, DIFICULDADE_ACESSO, etc.</li>
<li>Tratamento de exceções global</li>
<li>Implementação de @RestControllerAdvice com resposta estruturada (ErroResposta).</li>
<li>Erros como ID inválido e validações são tratados e retornam JSON amigáveis com status, timestamp, mensagem e URI.</li>
<li>Validação de dados</li>
<li>DTOs com anotações @Valid, @NotNull, @NotBlank.</li>
<li>Mensagens de erro padronizadas via GlobalExceptionHandler.</li>

<h3>Tecnologias Utilizadas</h3>
<li>Java 17, Spring Boot</li>
<li>JPA (Hibernate), MySQL</li>
<li>Bean Validation (Jakarta)</li>
<li>Spring MVC, Postman, Fetch/JS</li>
<li>@RestControllerAdvice, DTOs</li>





