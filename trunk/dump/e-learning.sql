INSERT INTO `time_slot` (`id`, `begin_time`, `end_time`, `day_id`) VALUES
(1, 8, 9, 1),
(2, 9, 10, 1),
(3, 10, 11, 1),
(4, 11, 12, 1),
(5, 12, 13, 1),
(6, 13, 14, 1),
(7, 14, 15, 1),
(8, 15, 16, 1),
(9, 16, 17, 1),
(10, 17, 18, 1);

INSERT INTO `day` (`id`, `name`) VALUES
(1, 'Lundi'),
(2, 'Mardi'),
(3, 'Mercredi'),
(4, 'Jeudi'),
(5, 'Vendredi'),
(6, 'Samedi'),
(7, 'Dimanche');

INSERT INTO `category` (`id`, `name`, `extension`) VALUES
(1, 'documents', 'doc,pdf,txt,docx,ppt,pptx'),
(2, 'images', 'png,gif,jpeg,jpg,bmp'),
(3, 'video', 'avi,swf,mpeg4');

INSERT INTO `affiliate` (`id`, `name`) VALUES
(1, 'Baraem Abdullah Bin Massoud'),
(2, 'Institut Imam Nafee'),
(3, 'Institut Imam Sahnoun'),
(4, 'Institut Formation Fondamentale');

INSERT INTO `gouvernorate` (`id`, `name`) VALUES
(1, 'KEBILI'),
(2, 'BIZERTE'),
(3, 'KAIROUAN'),
(4, 'BEJA'),
(5, 'ARIANA'),
(6, 'SIDI BOUZID'),
(7, 'MAHDIA'),
(8, 'SFAX'),
(9, 'BEN AROUS'),
(10, 'MONASTIR'),
(11, 'TATAOUINE'),
(12, 'TOZEUR'),
(13, 'MANOUBA'),
(14, 'SILIANA'),
(15, 'SOUSSE'),
(16, 'JENDOUBA'),
(17, 'ZAGHOUAN'),
(18, 'TUNIS'),
(19, 'NABEUL'),
(20, 'MEDENINE'),
(21, 'KASSERINE'),
(22, 'KEF'),
(23, 'GABES'),
(24, 'GAFSA');

