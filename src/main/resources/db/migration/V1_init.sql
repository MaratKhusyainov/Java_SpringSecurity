CREATE TABLE `score`
(
    `id`    INT(11) NOT NULL,
    `score` TINYINT(11) NULL DEFAULT 0,
    PRIMARY KEY (`id`)
);

INSERT INTO `score` (`id`, `score`)
VALUES (1, 50), (2, 30) ;


CREATE TABLE users
(
    `id`       INT          NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `email`    VARCHAR(255) NOT NULL,
    `score`    INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`score`) REFERENCES `score` (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC)

);

CREATE TABLE `roles`
(
    `id`   INT          NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `users_roles`
(
    `user_id` INT(11) NOT NULL,
    `role_id` INT(11) NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),

    FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id`),

    FOREIGN KEY (`role_id`)
        REFERENCES `roles` (`id`)
);


INSERT INTO `users` (`id`, `username`, `password`, `email`, `score`)
VALUES ('1', 'Ivan', '123456789', 'tom@gmail.com', '1') ,
       ('2', 'Sergei', '987654321', 'john@gmail.com', '2');

INSERT INTO `roles` (`name`)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');

INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES (1, 1),
       (2, 2);
