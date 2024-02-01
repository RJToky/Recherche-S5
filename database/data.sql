INSERT INTO categorie VALUES
    (default, 'Telephone'),
    (default, 'Ordinateur');

INSERT INTO produit VALUES
    (default, 1, 'Samsung S20', 500000, 9),
    (default, 1, 'Nokia Blue', 100000, 4),
    (default, 1, 'Redmi 9C', 350000, 6),
    (default, 2, 'Acer Nitron', 1500000, 6),
    (default, 2, 'HP ProBook', 2300000, 5),
    (default, 2, 'MSI KATANA', 4500000, 3);

INSERT INTO parametre VALUES
    (default, 'prix'),
    (default, 'qualite'),
    (default, 'rapport');

INSERT INTO signification VALUES
    (default, 'meilleur', 'ORDER BY ###', 2),
    (default, 'pire', 'ORDER BY ###', 2),
    (default, 'moins chere', 'ORDER BY prix ASC', 2),
    (default, 'plus chere', 'ORDER BY prix DESC', 2),
    (default, 'moins de', 'prix <= ---', 1),
    (default, 'plus de', 'prix >= ---', 1),
    (default, 'top', 'limit ***', 3);


---------------------------------------------------


INSERT INTO categorie VALUES
    (default, 'Telephone'),
    (default, 'Ordinateur');

INSERT INTO produit VALUES
    (default, 1, 'Samsung S20', 1500000, 7),
    (default, 1, 'Asus Rog 2', 2000000, 9),
    (default, 1, 'Aquos SHV39', 200000, 6),
    (default, 1, 'Meizu', 200000, 4),

    (default, 2, 'Asus TUF', 3500000, 7),
    (default, 2, 'Toshiba', 1300000, 4),
    (default, 2, 'Thinkpad', 1500000, 5),
    (default, 2, 'Nec', 1000000, 3);

INSERT INTO parametre VALUES
    (default, 'prix'),
    (default, 'qualite'),
    (default, 'rapport');

INSERT INTO signification VALUES
    (default, 'meilleur', 'ORDER BY ###', 2),
    (default, 'pire', 'ORDER BY ###', 2),
    (default, 'moins chere', 'ORDER BY prix ASC', 2),
    (default, 'plus chere', 'ORDER BY prix DESC', 2),
    (default, 'moins de', 'prix <= ---', 1),
    (default, 'plus de', 'prix >= ---', 1),
    (default, 'top', 'limit ***', 3);
