package ru.cherkasov.SecondLab.model;
import com.fasterxml.jackson.databind.node.DoubleNode;
import lombok.Builder;
import  lombok.Data;

@Data
@Builder
public class Response {
    /***
     *  Уникальный идентификатор сообщения
     */
    private String uid;
    /***
     *  Уникальный идентификатор операции
     */
    private String operationUid;
    /***
     *  Время создания сообщения
     */
    private String systemTime;
    /***
     *  Код
     */
    private Codes code;
    /***
     *  Бонус
     */
    private Double annualBonus;
    /***
     *  Код ошибки
     */
    private ErrorCodes errorCode;
    /***
     *  Сообщение ошибки
     */
    private ErrorMessages errorMessage;
}
