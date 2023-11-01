package ru.cherkasov.SecondLab.service.Calculate;

import org.junit.jupiter.api.Test;
import ru.cherkasov.SecondLab.model.Positions;

import javax.swing.text.Position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnnualBonusServiceTest {

    @Test
    void calculate() {
        Positions positions = Positions.HR;
        double bouns = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        double result = new AnnualBonusServiceImpl().calculate(positions, salary, bouns, workDays);
        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testCalculateQuarterlyBonusForManager() {
        AnnualBonusService service = new AnnualBonusServiceImpl();
        Positions position = Positions.PM;
        double salary = 5000.0;
        double bonus = 0.2;
        boolean isManager = true;
        double expectedBonus = 249.31506849315068;

        double actualBonus = service.calculateQuarterlyBonus(position, salary, bonus, isManager);

        assertThat(actualBonus).isEqualTo(expectedBonus);
    }

    @Test
    public void testCalculateQuarterlyBonusForNonManager() {

        AnnualBonusService service = new AnnualBonusServiceImpl();
        Positions position = Positions.DEV;
        double salary = 4000.0;
        double bonus = 0.15;
        boolean isManager = false;

        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateQuarterlyBonus(position, salary, bonus, isManager);
        });
    }
}