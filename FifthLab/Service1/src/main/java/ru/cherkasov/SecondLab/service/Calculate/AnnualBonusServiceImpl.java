package ru.cherkasov.SecondLab.service.Calculate;

import org.springframework.stereotype.Service;
import ru.cherkasov.SecondLab.model.Positions;

import java.time.LocalDate;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        int daysInYear = isLeapYear() ? 366 : 365;
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }

    @Override
    public double calculateQuarterlyBonus(Positions position, double salary, double bonus, boolean isManager) {
        if (!isManager) {
            throw new IllegalArgumentException("Avaliable for managers only");
        }

        int workDays = 91;

        return salary * bonus * workDays * position.getPositionCoefficient() / 365;
    }


    private boolean isLeapYear() {
        int year = LocalDate.now().getYear();
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

}
