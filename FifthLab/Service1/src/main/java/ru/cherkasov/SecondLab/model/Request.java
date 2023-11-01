package ru.cherkasov.SecondLab.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    /***
     *  Уникальный идентификатор сообщение
     */
    @NotBlank
    @Size(max = 32)
    private String uid;

    /***
     *  Уникальный идентификатор операции
     */
    @NotBlank
    @Size(max = 32)
    private String operationUid;
    /***
     *  Имя системы отправителя
     */
    private Systems systemName;

    /***
     *  Время создания сообщения
     */
    @NotBlank
    private String systemTime;
    /***
     *  Наименование ресурса
     */
    private String source;
    /***
     *  Позиция в организации
     */
    private Positions position;
    /***
     *  Зарплата
     */
    private Integer salary;
    /***
     *  Бонус для менеджеров
     */
    private Double bonus;
    /***
     *  Отработано дней в году
     */
    private Integer workDays;


    /***
     *  Уникальный идентификатор коммуникации
     */
    @Min(1)
    @Max(100000)
    private int communicationId;
    /***
     *  Уникальный идентификатор шаблона
     */
    private int templateId;
    /***
     *  Код продукта
     */
    private int productCode;
    /***
     *  Смс код
     */
    private int smsCode;

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName=" + systemName +
                ", systemTime='" + systemTime + '\'' +
                ", source ='" + source + '\'' +
                ", communicationId='" + communicationId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productCode='" + smsCode + '\'' +
                '}';
    }
}