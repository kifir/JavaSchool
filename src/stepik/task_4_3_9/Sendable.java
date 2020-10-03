package stepik.task_4_3_9;

/***
 * Интерфейс: сущность, которую можно отправить по почте.
 * У такой сущности можно получить от кого и кому направляется письмо.
*/
public interface Sendable {
    String getFrom();
    String getTo();
}
