INSERT INTO `service_center_new`.`teams`
(`name`)
VALUES
  ('Бригада 1'),
  ('Бригада 2'),
  ('Бригада 3');

INSERT INTO `service_center_new`.`states`
(`name`)
VALUES
  ('Прийнятий'),
  ('Призначений виїзд'),
  ('Відкладений'),
  ('Виконаний'),
  ('Відмінений');

INSERT INTO `service_center_new`.`services`
(`name`, `price`)
VALUES
  ('Встановлення пральної машини', '299'),
  ('Встановлення кондиціонера', '1999'),
  ('Встановлення водонагрівача', '599'),
  ('Ремонт великої побутової техніки', '149'),
  ('Профілактика кондиціонера', '599'),
  ('Профілактика водонагрівача', '299');

INSERT INTO `service_center_new`.`roles`
(`name`)
VALUES
  ('client'),
  ('dispatcher'),
  ('administrator');

INSERT INTO `service_center_new`.`users`
(`name`, `address`, `phone`, `e-mail`, `password`, `roles_id`)
VALUES
  ('Іванченко Іван Іванович', 'м. Дніпро, пр. Яворницького, 55, кв. 9',
   '+380671234567', 'ivan111111@gmail.com', '111111', '1'),
  ('Петренко Петро Петрович', 'м. Дніпро, пр. Поля, 49, кв. 21',
   '+380501234567', 'petro222222@gmail.com', '222222', '1'),
  ('Сидоренко Сидір Сидорович', 'м. Дніпро, вул. Січеславська Наберіжна,
   10, кв. 5', '+380931234567', 'sydir333333@gmail.com', '333333', '1');

INSERT INTO `service_center_new`.`orders`
(`address`, `phone`, `creation_date`, `execution_date`, `users_id`,
 `teams_id`, `services_id`, `states_id`)
VALUES
  ('м. Дніпро, пр. Яворницького, 55, кв. 9', '+380671234567', '2017-06-22',
   '2017-06-23', '1', '1', '1', '4'),
  ('м. Дніпро, пр. Поля, 49, кв. 21', '+380501234567', '2017-06-23',
   '2017-06-25', '2', '2', '2', '2'),
  ('м. Дніпро, вул. Січеславська Наберіжна, 10, кв. 5', '+380931234567',
   NULL, NULL, '3', NULL, '3', '1');
