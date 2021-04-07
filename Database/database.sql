-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 07 Kwi 2021, 10:13
-- Wersja serwera: 10.4.11-MariaDB
-- Wersja PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `aplikacja_mobilna`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategoria`
--

CREATE TABLE `kategoria` (
  `idk` int(11) NOT NULL,
  `kategoria` varchar(150) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Zrzut danych tabeli `kategoria`
--

INSERT INTO `kategoria` (`idk`, `kategoria`) VALUES
(1, 'Series'),
(2, 'Book'),
(5, 'Movies');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `obiekty`
--

CREATE TABLE `obiekty` (
  `idp` int(11) NOT NULL,
  `kategoria_id` int(11) NOT NULL,
  `nazwa` varchar(300) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `autor_rezyser` varchar(300) COLLATE utf8mb4_polish_ci NOT NULL,
  `opis_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Zrzut danych tabeli `obiekty`
--

INSERT INTO `obiekty` (`idp`, `kategoria_id`, `nazwa`, `autor_rezyser`, `opis_id`) VALUES
(25, 5, 'The Last Samurai', 'Edward Zwick', 22),
(26, 5, 'Gladiator', 'Ridley Scott', 23),
(27, 5, 'The Revenant', 'Alejandro G. Inarritu', 24),
(28, 1, 'Vikings', 'Michael Hirst', 25),
(29, 1, 'The Walking Dead', 'Lawrence Gilliard', 26),
(30, 1, 'Game of Thrones', 'Tim Van Patten', 27),
(31, 2, 'Moby Dick', 'Herman Melville', 28),
(32, 2, 'The Old Man and the Sea', 'Ernest Hemingway', 29),
(33, 2, 'The Hobbit', 'J. R. R. Tolkien', 30);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `opis`
--

CREATE TABLE `opis` (
  `ido` int(11) NOT NULL,
  `opis` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Zrzut danych tabeli `opis`
--

INSERT INTO `opis` (`ido`, `opis`) VALUES
(22, 'Set in Japan during the 1870s, this movie tells the story of Captain Nathan Algren (Tom Cruise), a respected American military officer hired by the Emperor of Japan to train the countrys first Army in the art of modern warfare. The Imperial Omura (Masato Harada) cabinet attempts to eradicate the ancient Imperial Samurai warriors in preparation for more Westernized and trade-friendly government policies, Algren finds himself unexpectedly impressed and influenced by his encounters with the Samurai, which places him at the center of a struggle between two eras and two worlds, with only his own sense of honor to guide him.'),
(23, 'In 180 A.D. Rome, the weary and dying emperor, Marcus Aurelius, names his loyal and triumphant general, Maximus Decimus Meridius, his successor and protector of Rome, much to the dismay of his haughty and unbalanced son, Commodus. But, instead, death and entrapment await, as the embittered and blind with rage rival rewards Romes hero with an order for his execution, only to wind up as a slave to the former gladiator, Proximo. From the vast deserts of North Africa, a new Maximo will rise as a gladiator, hacking and slashing his way through all the way up to Mother Rome and the unsuspecting dictator, Commodus. But will the popular general ever find peace in a long-awaited retribution?'),
(24, 'While exploring uncharted wilderness in 1823, legendary frontiersman Hugh Glass sustains injuries from a brutal bear attack. When his hunting team leaves him for dead, Glass must utilize his survival skills to find a way back home while avoiding natives on their own hunt. Grief-stricken and fueled by vengeance, Glass treks through the wintry terrain to track down John Fitzgerald, the former confidant who betrayed and abandoned him.'),
(25, 'The adventures of a Ragnar Lothbrok: the greatest hero of his age. The series tells the saga of Ragnars band of Viking brothers and his family as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods: legend has it that he was a direct descendant of Odin, the god of war and warriors.'),
(26, 'The Walking Dead tells the story of the months and years that follow after a zombie apocalypse. It follows a group of survivors, led by former police officer Rick Grimes, who travel in search of a safe and secure home. As the world overrun by the dead takes its toll on the survivors, their interpersonal conflicts present a greater danger to their continuing survival than the walkers that roam the country. Over time, the characters are changed by the constant exposure to death and some grow willing to do anything to survive. Based on the comic book series of the same name by Robert Kirkman, Tony Moore and Charlie Adlard.'),
(27, 'Based on the best-selling book series \"A Song of Ice and Fire\" by George R.R. Martin, this sprawling HBO drama is set in a world where summers span several decades and winters can last a lifetime. From the scheming south and the savage eastern lands, to the frozen north and ancient Wall that protects the realm from the mysterious darkness beyond, the powerful families of the Seven Kingdoms are locked in a battle for the Iron Throne. This is a story of duplicity and treachery, nobility and honor, conquest and triumph. In the Game of Thrones, you either win or you die.'),
(28, 'The novel Moby Dick by Herman Melville is an epic tale of the voyage of the whaling ship the Pequod and its captain, Ahab, who relentlessly pursues the great Sperm Whale (the title character) during a journey around the world. The narrator of the novel is Ishmael, a sailor on the Pequod who undertakes the journey out of his affection for the sea.'),
(29, 'The Old Man and the Sea tells the story of a battle between an aging, experienced fisherman, Santiago, and a large marlin.'),
(30, 'The Hobbit is set within Tolkiens fictional universe and follows the quest of home-loving Bilbo Baggins, the titular hobbit, to win a share of the treasure guarded by Smaug the dragon. Bilbos journey takes him from light-hearted, rural surroundings into more sinister territory.');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `kategoria`
--
ALTER TABLE `kategoria`
  ADD PRIMARY KEY (`idk`);

--
-- Indeksy dla tabeli `obiekty`
--
ALTER TABLE `obiekty`
  ADD PRIMARY KEY (`idp`);

--
-- Indeksy dla tabeli `opis`
--
ALTER TABLE `opis`
  ADD PRIMARY KEY (`ido`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `kategoria`
--
ALTER TABLE `kategoria`
  MODIFY `idk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `obiekty`
--
ALTER TABLE `obiekty`
  MODIFY `idp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT dla tabeli `opis`
--
ALTER TABLE `opis`
  MODIFY `ido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
