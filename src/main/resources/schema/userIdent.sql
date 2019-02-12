CREATE TABLE IF NOT EXISTS `user_identifiers`(
    `uid` VARCHAR(36) NOT NULL,
    `password_hash` VARCHAR(150) NOT NULL,
    `username` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`uid`),
    UNIQUE KEY `username_key` (`username`)
);