CREATE TABLE IF NOT EXISTS item
(
    item_id     VARCHAR(40) NOT NULL,
    name        VARCHAR(20),
    description VARCHAR(200),
    price       DECIMAL(8, 2),
    count       INT,
    image_url_1 VARCHAR(40),
    image_url_2 VARCHAR(40),
    PRIMARY KEY (item_id)
);

CREATE TABLE IF NOT EXISTS tag
(
    tag_id SERIAL NOT NULL,
    name   VARCHAR(20),
    PRIMARY KEY (tag_id)
);

CREATE TABLE IF NOT EXISTS item_tag
(
    item_id VARCHAR(40),
    tag_id  INT NOT NULL,
    FOREIGN KEY (item_id)
        REFERENCES item (item_id),
    FOREIGN KEY (tag_id)
        REFERENCES tag (tag_id)
);