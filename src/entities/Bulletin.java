package entities;

public class Bulletin {
    private Student student;

    private Double firstGrade;
    private Double secondGrade;
    private Double thirdGrade;
    private Double fourthGrade;

    private int totalClasses;
    private int attendedClasses;

    public Bulletin() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getFirstGrade() {
        return firstGrade;
    }

    public void setFirstGrade(Double firstGrade) {
        this.firstGrade = firstGrade;
    }

    public Double getSecondGrade() {
        return secondGrade;
    }

    public void setSecondGrade(Double secondGrade) {
        this.secondGrade = secondGrade;
    }

    public Double getThirdGrade() {
        return thirdGrade;
    }

    public void setThirdGrade(Double thirdGrade) {
        this.thirdGrade = thirdGrade;
    }

    public Double getFourthGrade() {
        return fourthGrade;
    }

    public void setFourthGrade(Double fourthGrade) {
        this.fourthGrade = fourthGrade;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
    }

    // CALCULA NOTA
    public double calculateAverage() {
        double sum = 0;
        int total = 0;

        if (getFirstGrade() != null) {
            sum += getFirstGrade();
            total++;
        }

        if (getSecondGrade() != null) {
            sum += getSecondGrade();
            total++;
        }

        if (getThirdGrade() != null) {
            sum += getThirdGrade();
            total++;
        }

        if (getFourthGrade() != null) {
            sum += getFourthGrade();
            total++;
        }

        return total == 0 ? 0 : sum / total;
    }

    // CALCULA FREQUÊNCIA
    public double calculeAttendante() {
        if (getTotalClasses() == 0) {
            return 0;
        }
        return (double) (getAttendedClasses() * 100) / getTotalClasses();
    }

    // CALCULA NUMERO DE FALTAS
    public int calculateAbsences() {
        return getTotalClasses() - getAttendedClasses();
    }

    // CALCULA SITUAÇÃO
    public String situation() {
        if (calculeAttendante() < 75) {
            return "REPROVADO POR FALTA";
        }

        if (calculateAverage() >= 7) {
            return "APROVADO";
        } else if (calculateAverage() <= 4) {
            return "REPROVADO POR NOTA";
        }

        return "RECUPERAÇÃO";
    }

    // FORMATA A FORMA DE MOSTRAR A NOTA SE NÃO EXISTIR, EVITA O NULL
    private String formatGrade(Double grade) {
        if (grade == null) {
            return "Não lançada";
        }
        return String.format("%.1f", grade);
    }

    public String showGrades() {
        return "\n" +
                "Aluno(a): " + student.getNome() + "\n" +
                "---------------------------------------------\n" +
                "1º Bimestre: " + formatGrade(getFirstGrade()) + "\n" +
                "2º Bimestre: " + formatGrade(getSecondGrade()) + "\n" +
                "3º Bimestre: " + formatGrade(getThirdGrade()) + "\n" +
                "4º Bimestre: " + formatGrade(getFourthGrade()) + "\n" +
                "---------------------------------------------";
    }

    public String showAttendance() {
        return "\n" +
                "Aluno(a): " + student.getNome() + "\n" +
                "---------------------------------------------\n" +
                "Total de aulas: " + totalClasses + "\n" +
                "Presenças: " + attendedClasses + "\n" +
                "Faltas: " + calculateAbsences() + "\n" +
                String.format("Frequência: %.2f%%%n", calculeAttendante()) +
                "---------------------------------------------";
    }

    @Override
    public String toString() {
        return "\n" +
                "╔═══════════════════════════════════════════╗\n" +
                "                 BOLETIM\n" +
                "╚═══════════════════════════════════════════╝\n" +
                "Aluno(a): " + student.getNome() + "\n" +
                "---------------------------------------------\n" +
                "1º Bimestre: " + formatGrade(firstGrade) + "\n" +
                "2º Bimestre: " + formatGrade(secondGrade) + "\n" +
                "3º Bimestre: " + formatGrade(thirdGrade) + "\n" +
                "4º Bimestre: " + formatGrade(fourthGrade) + "\n" +
                "---------------------------------------------\n" +
                String.format("Média: %.2f%n", calculateAverage()) +
                "---------------------------------------------\n" +
                "Total de aulas: " + totalClasses + "\n" +
                "Presenças: " + attendedClasses + "\n" +
                "Faltas: " + calculateAbsences() + "\n" +
                String.format(
                        "Frequência: %.2f%%%n",
                        calculeAttendante()
                ) +
                "---------------------------------------------\n" +
                "Situação: " + situation() + "\n" +
                "═════════════════════════════════════════════";
    }
}
