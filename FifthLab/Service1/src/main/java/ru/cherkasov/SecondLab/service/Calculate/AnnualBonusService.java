package ru.cherkasov.SecondLab.service.Calculate;

import org.springframework.stereotype.Service;
import ru.cherkasov.SecondLab.model.Positions;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
    double calculateQuarterlyBonus(Positions position, double salary, double bonus, boolean isManager);
}
