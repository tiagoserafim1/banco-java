# 🏦 Sistema Bancário em Java – Projeto OOP

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white"/>
  <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white"/>
  <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white"/>
  <img src="https://img.shields.io/badge/Status-Em%20desenvolvimento-yellow?style=for-the-badge"/>
</p>

---

## ✨ Descrição do Projeto

Sistema bancário desenvolvido em Java como projeto de estudo de **Programação Orientada a Objetos (OOP)**. Permite criar contas, realizar operações bancárias e consultar o histórico de transações de forma prática e organizada.

> Foco no aprendizado de classes, objetos, listas, encapsulamento e lógica de negócio.

---

## 🚀 Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| 👤 Criar conta | Cadastro com nome, saldo inicial, número e senha |
| 💰 Depositar | Depósito com validação de valor |
| 💸 Sacar | Saque com validação de saldo |
| 🔄 Transferir | Transferência entre contas com extrato detalhado |
| 📋 Extrato | Histórico completo de operações com saldo atual |
| 🔒 Autenticação | Senha com bloqueio após 3 tentativas erradas |
| 🚫 Anti-duplicata | Verificação de número de conta duplicado no cadastro |

---

## 📂 Estrutura do Projeto

```
Banco/
│
├─ src/
│   ├─ MenuBanco.java   # Classe principal com menu interativo
│   └─ Conta.java       # Classe que representa uma conta bancária
│
└─ README.md
```

---

## 💡 Conceitos aplicados

- **Encapsulamento** — atributos privados com acesso via métodos públicos
- **Responsabilidade única** — cada classe cuida do que é seu
- **Retorno boolean** — métodos `sacar`, `depositar` e `transferirPara` retornam sucesso ou falha
- **Reutilização de código** — `buscarConta` e `autenticarConta` usados em todas as operações

---

## 🚧 Próximos passos

- [ ] Integração com banco de dados MySQL
- [ ] Data e hora nas operações do extrato
- [ ] Opção de alterar senha

---

## 👤 Autor

**Tiago Serafim**

[![GitHub](https://img.shields.io/badge/GitHub-tiagoserafim1-181717?style=flat&logo=github)](https://github.com/tiagoserafim1)