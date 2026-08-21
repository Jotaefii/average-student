<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0f1730,50:1a2b6b,100:2f54d1&height=180&section=header&text=School%20system&fontSize=45&fontColor=ffffff&fontAlignY=40&desc=Sistema%20Escolar%20em%20Java&descAlignY=65&descSize=18&animation=fadeIn" />

<img src="https://skillicons.dev/icons?i=java,idea&theme=dark" />

<br><br>

![Java](https://img.shields.io/badge/Java-2f54d1?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20desenvolvimento-0f1730?style=for-the-badge)

</div>

<br>

## 📖 Sobre o projeto

**Average Student** é um sistema escolar desenvolvido em **Java puro**, criado como projeto de estudo aplicando conceitos de **Programação Orientada a Objetos (POO)**.

O sistema simula o funcionamento de uma escola com **três perfis de usuário** — Diretor, Professor e Aluno — cada um com login próprio via **CPF e senha** e um menu de funcionalidades específico de acordo com seu papel dentro da instituição.

<br>

## 🔐 Como funciona o login

Ao iniciar o sistema, o usuário informa **CPF e senha**. O sistema valida as credenciais e redireciona automaticamente para o menu correspondente ao seu perfil:

| Perfil | Acesso |
|---|---|
| 👨‍💼 Diretor | Menu de gestão da escola |
| 👨‍🏫 Professor | Menu de lançamento de notas e frequência |
| 🎓 Aluno | Menu de consulta de boletim |

<br>

## ⚙️ Funcionalidades por perfil

### 👨‍💼 Diretor
- Cadastro de professores
- Cadastro de alunos

### 👨‍🏫 Professor
- Lançamento de notas
- Lançamento de frequência

### 🎓 Aluno
- Consulta de notas
- Consulta de boletim

<br>

## 🛠️ Tecnologias utilizadas

- **Java puro** — sem frameworks ou ferramentas de build, com foco em POO (classes, encapsulamento, herança e polimorfismo)
- Armazenamento em **memória** (estruturas como `ArrayList`), sem persistência em banco de dados — os dados existem apenas durante a execução do programa

<br>

## 🚀 Como executar o projeto

### Pré-requisitos
- [JDK 17+](https://www.oracle.com/java/technologies/downloads/) instalado

### Passo a passo

```bash
# Clone o repositório
git clone https://github.com/Jotaefii/average-student.git

# Entre na pasta do projeto
cd average-student

# Compile os arquivos .java
javac *.java

# Execute o programa (troque "Main" pelo nome da sua classe principal)
java Main
```

> 💡 Se preferir, também dá pra abrir o projeto direto na sua IDE (IntelliJ, Eclipse, VS Code) e rodar clicando em "Run" na classe que tem o `main()`.

## 👤 Autor

<div align="center">

**João Felipe**

Estudante de Análise e Desenvolvimento de Sistemas, com foco em back-end Java.

<a href="https://linkedin.com/in/jotaefi" target="_blank">
<img src="https://img.shields.io/badge/LinkedIn-2f54d1?style=for-the-badge&logo=linkedin&logoColor=white" />
</a>
<a href="https://instagram.com/eujotaefi" target="_blank">
<img src="https://img.shields.io/badge/Instagram-1a2b6b?style=for-the-badge&logo=instagram&logoColor=white" />
</a>
<a href="mailto:joaofelipecode@gmail.com" target="_blank">
<img src="https://img.shields.io/badge/Gmail-0f1730?style=for-the-badge&logo=gmail&logoColor=white" />
</a>

</div>

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:2f54d1,50:1a2b6b,100:0f1730&height=100&section=footer" />
