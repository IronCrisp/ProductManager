/*Without having proper knowledge of MySQL, this is what I successfully managed to do
when it comes to adding query instructions to execute a table with contents into the
database.*/

/*Creates the table of products with 6 labeled columns with their respective variables*/
CREATE TABLE IF NOT EXISTS `products` (
`id` int NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `releaseDate` varchar(50) DEFAULT NULL,
  `price` double(10, 2) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `rating` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

/*Adds predefined values to the table*/
INSERT INTO `products` (`id`, `title`, `releaseDate`, `price`, `genre`, `rating`) VALUES
('31011', 'Call of Duty: Black Ops II', 'Nov 13, 2012', 20.00, 'Shooter', 'M'),
('30762', 'Battlefield 3', 'Oct 28, 2011', 20.00, 'Shooter', 'M'),
('29747', 'Klonoa Phantasy Revere Series', 'July 8, 2022' , 30.00, '2D platforming', 'E'),
('22900', 'Grand Theft Auto IV', 'April 29, 2008', 15.00, 'Action-Adventure', 'M'),
('36930', 'Gran Turismo 7', 'March 4, 2022', 30.00, 'Racing', 'E'),
('30232', 'Alone in the Dark: Inferno', 'November 18, 2008', '15.00', 'Horror', 'M');

/*defines the id column to sort the table from lowest to highest*/
ALTER TABLE `products`
ADD PRIMARY KEY (`id`);

ALTER TABLE `products`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 32