INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('6d62d909-f957-430e-8689-b5129c0bb75e', 'Weave special',
        'Limited issue Weave items.', 17.15, 33, '/images/weave1.jpg',
        '/images/weave2.jpg');
INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('a0a4f044-b040-410d-8ead-4de0446aec7e', 'Nerd leg',
        'For all those leg lovers out there. A perfect example of a swivel chair trained calf. Meticulously trained on a diet of sitting and Pina Coladas. Phwarr...',
        7.99, 115, '/images/bit_of_leg_1.jpeg',
        '/images/bit_of_leg_2.jpeg');
INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('808a2de1-1aaa-4c25-a9b9-6612e8f29a38', 'Crossed',
        'A mature item, crossed, with an air of nonchalance.', 17.32, 738,
        '/images/cross_1.jpeg', '/images/cross_2.jpeg');
INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('510a0d7e-8e83-4193-b483-e27e09ddc34d', 'SuperSport XL',
        'Ready for action. Engineers: be ready to smash that next bug! Be ready, with these super-action-sport-masterpieces. This particular engineer was chased away from the office with a stick.',
        15.00, 820, '/images/puma_1.jpeg', '/images/puma_2.jpeg');
INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('03fef6ac-1896-4ce8-bd69-b798f85c6e0b', 'Holy',
        'Items fit for a Messiah. You too can experience walking in water with these special edition beauties. Each hole is lovingly proggled to leave smooth edges. The only item approved by a higher power.',
        99.99, 1, '/images/holy_1.jpeg', '/images/holy_2.jpeg');
INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('d3588630-ad8e-49df-bbd7-3167f7efb246', 'YouTube.item',
        'We were not paid to sell this item. Its just a bit geeky.', 10.99, 801,
        '/images/youtube_1.jpeg', '/images/youtube_2.jpeg');
INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('819e1fbf-8b7e-4f6d-811f-693534916a8b', 'Figueroa',
        'enim officia aliqua excepteur esse deserunt quis aliquip nostrud anim', 14, 808,
        '/images/WAT.jpg', '/images/WAT2.jpg');
INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('abc4f044-b040-410d-8ead-4de0446aec7e', 'Classic', 'Keep it simple.', 12, 127,
        '/images/classic.jpg', '/images/classic2.jpg');
INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('3395a43e-2d88-40de-b95f-e00e1502085b', 'Colourful',
        'proident occaecat irure et excepteur labore minim nisi amet irure', 18, 438,
        '/images/colourful_items.jpg', '/images/colourful_items.jpg');
INSERT INTO item (item_id, name, description, price, count, image_url_1, image_url_2)
VALUES ('837ab141-399e-4c1f-9abc-bace40296bac', 'Cat items',
        'consequat amet cupidatat minim laborum tempor elit ex consequat in', 15, 175,
        '/images/catitems.jpg', '/images/catitems2.jpg');

INSERT INTO tag (name)
VALUES ('brown');
INSERT INTO tag (name)
VALUES ('geek');
INSERT INTO tag (name)
VALUES ('formal');
INSERT INTO tag (name)
VALUES ('blue');
INSERT INTO tag (name)
VALUES ('skin');
INSERT INTO tag (name)
VALUES ('red');
INSERT INTO tag (name)
VALUES ('action');
INSERT INTO tag (name)
VALUES ('sport');
INSERT INTO tag (name)
VALUES ('black');
INSERT INTO tag (name)
VALUES ('magic');
INSERT INTO tag (name)
VALUES ('green');

INSERT INTO item_tag (item_id, tag_id)
VALUES ('6d62d909-f957-430e-8689-b5129c0bb75e', '2');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('6d62d909-f957-430e-8689-b5129c0bb75e', '9');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('a0a4f044-b040-410d-8ead-4de0446aec7e', '4');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('a0a4f044-b040-410d-8ead-4de0446aec7e', '5');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('808a2de1-1aaa-4c25-a9b9-6612e8f29a38', '4');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('808a2de1-1aaa-4c25-a9b9-6612e8f29a38', '6');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('808a2de1-1aaa-4c25-a9b9-6612e8f29a38', '7');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('808a2de1-1aaa-4c25-a9b9-6612e8f29a38', '3');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('510a0d7e-8e83-4193-b483-e27e09ddc34d', '8');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('510a0d7e-8e83-4193-b483-e27e09ddc34d', '9');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('510a0d7e-8e83-4193-b483-e27e09ddc34d', '3');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('03fef6ac-1896-4ce8-bd69-b798f85c6e0b', '10');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('03fef6ac-1896-4ce8-bd69-b798f85c6e0b', '7');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('d3588630-ad8e-49df-bbd7-3167f7efb246', '2');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('d3588630-ad8e-49df-bbd7-3167f7efb246', '3');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('819e1fbf-8b7e-4f6d-811f-693534916a8b', '3');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('819e1fbf-8b7e-4f6d-811f-693534916a8b', '11');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('819e1fbf-8b7e-4f6d-811f-693534916a8b', '4');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('abc4f044-b040-410d-8ead-4de0446aec7e', '1');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('abc4f044-b040-410d-8ead-4de0446aec7e', '11');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('3395a43e-2d88-40de-b95f-e00e1502085b', '1');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('3395a43e-2d88-40de-b95f-e00e1502085b', '4');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('837ab141-399e-4c1f-9abc-bace40296bac', '1');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('837ab141-399e-4c1f-9abc-bace40296bac', '11');
INSERT INTO item_tag (item_id, tag_id)
VALUES ('837ab141-399e-4c1f-9abc-bace40296bac', '3');