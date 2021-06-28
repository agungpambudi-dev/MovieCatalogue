package com.pamsdev.moviecatalogue.utils;

import com.pamsdev.moviecatalogue.data.source.remote.response.MovieResponse;
import com.pamsdev.moviecatalogue.data.source.remote.response.TvResponse;

import java.util.ArrayList;

public class DataDummy {

    public static ArrayList<MovieResponse> setMovieDummy() {

        ArrayList<MovieResponse> listMovie = new ArrayList<>();

        listMovie.add(new MovieResponse(
                "0",
                "poster_a_start_is_born.jpg",
                "A Star Is Born",
                "October 19, 2018",
                "3.75",
                "Seasoned musician Jackson Maine discovers  and falls in love with  struggling artist Ally. She has just about given up on herdream to make it big as a singer until Jackson coaxes her into\n" +
                        " the spotlight. But even as Allys career takes off, the personal side of their relationship is breaking down, as Jackson fights an ongoing battle with his own internal demons."
        ));
        listMovie.add(new MovieResponse(
                "1",
                "poster_alita.jpg",
                "Alita: Battle Angel",
                "February 14, 2019",
                "3.6",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned\n" +
                        " cyborg shell is the heart and soul of a young woman with an extraordinary past"
        ));
        listMovie.add(new MovieResponse(
                "2",
                "poster_aquaman.jpg",
                "Aquaman",
                "December 14, 2018",
                "3.5",
                "Once home to the most advanced civilization on Earth, the city of Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer\n" +
                        " the remaining oceanic people  and then the surface world. Standing in his way is Aquaman, Orms half-human, half-Atlantean brother and true heir to the throne. With help from royal counselor Vulko,\n" +
                        " Aquaman must retrieve the legendary Trident of Atlan and embrace his destiny as protector of the deep."
        ));
        listMovie.add(new MovieResponse(
                "3",
                "poster_bohemian.jpg",
                "Bohemian Rhapsody",
                "October 27, 2018",
                "4.0",
                "Freddie Mercury  the lead singer of Queen  defies stereotypes and convention to become one of historys most beloved entertainers. The bands revolutionary sound and popular songs lead to Queens\n" +
                        " meteoric rise in the 1970s. After leaving the group to pursue a solo career, Mercury reunites with Queen for the benefit concert Live Aid  resulting in one of the greatest performances in rock\n" +
                        " n roll history."
        ));
        listMovie.add(new MovieResponse(
                "4",
                "poster_cold_persuit.jpg",
                "Cold Pursuit",
                "February 21, 2019",
                "3.0",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his sons murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating\n" +
                        " Vikings associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."
        ));
        listMovie.add(new MovieResponse(
                "5",
                "poster_creed.jpg",
                "Creed II",
                "November 28, 2018",
                "3.4",
                "In 1985, Russian boxer Ivan Drago killed former U.S. champion Apollo Creed in a tragic match that stunned the world. Against the wishes of trainer Rocky Balboa, Apollos son Adonis Johnson accepts\n" +
                        " a challenge from Dragos son  another dangerous fighter. Under guidance from Rocky, Adonis trains for the showdown of his life  a date with destiny that soon becomes his obsession.\n" +
                        " Now, Johnson and Balboa must confront their shared legacy as the past comes back to haunt each man."
        ));
        listMovie.add(new MovieResponse(
                "6",
                "poster_crimes.jpg",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "November 14, 2018",
                "3.4",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his causeelevating wizards above all non-magical beings. The only one capable of putting a stop to him is the\n" +
                        " wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander,\n" +
                        " who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world."
        ));
        listMovie.add(new MovieResponse(
                "7",
                "poster_glass.jpg",
                "Glass",
                "January 17, 2019",
                "3.0",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile,\n" +
                        " the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
        ));
        listMovie.add(new MovieResponse(
                "8",
                "poster_how_to_train.jpg",
                "How To Train Your Dragon: The Hidden World",
                "January 9, 2019",
                "3.8",
                "All seems well on the island of Berk as Vikings and dragons live together in peace and harmony. Now a Viking leader, Hiccup finds himself increasingly attracted to Astrid, while his beloved dragon\n" +
                        " Toothless meets an enchanting creature who captures his eye. When the evil Grimmel launches a devious plan to wipe out all the dragons, Hiccup must unite both clans to find Caldera, a hidden land\n" +
                        " that holds the key to saving Toothless and his flying friends."
        ));
        listMovie.add(new MovieResponse(
                "9",
                "poster_infinity_war.jpg",
                "Avanger Infinity War",
                "April 25, 2018",
                "4.2",
                "Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet  the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the\n" +
                        " artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment."
        ));

        return listMovie;
    }

    public static ArrayList<TvResponse> setTvDummy() {

        ArrayList<TvResponse> tvs = new ArrayList<>();

        tvs.add(new TvResponse(
                "0",
                "poster_arrow.jpg",
                "Arrow",
                "October 10, 2012",
                "4",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded\n"
        ));
        tvs.add(new TvResponse(
                "1",
                "poster_doom_patrol.jpg",
                "Doom Patrol",
                "February 15, 2019",
                "4",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities  but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose\n" +
                        " through The Chief, who brought them together to investigate the weirdest phenomena in existence  and to protect Earth from what they find"
        ));
        tvs.add(new TvResponse(
                "2",
                "poster_dragon_ball.jpg",
                "Dragon Ball",
                "February 26, 1986",
                "4",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very\n" +
                        " strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Gokus home. Together, they set off\n" +
                        " to find all seven and to grant her wish."));
        tvs.add(new TvResponse(
                "3",
                "poster_fairytail.jpg",
                "Fairy Tail",
                "October 12, 2009",
                "4",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu\n" +
                        " isn’t just any ordinary kid, hes a member of one of the worlds most infamous mage guilds: Fairy Tail"));
        tvs.add(new TvResponse(
                "4",
                "poster_family_guy.jpg",
                "Family Guy",
                "January 31, 1999",
                "4",
                "Sick, twisted, politically incorrect and Freakin Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids.\n" +
                        " Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, hes not very\n" +
                        " bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his\n" +
                        " own life issues."));
        tvs.add(new TvResponse(
                "5",
                "poster_flash.jpg",
                "The Flash",
                "October 7, 2014",
                "4",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him\n" +
                        " the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only meta-human who was created\n" +
                        " in the wake of the accelerator explosion  and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few\n" +
                        " close friends and associates know that Barry is literally the fastest man alive, but it wont be long before the world learns what Barry Allen has become…The Flash."));
        tvs.add(new TvResponse(
                "6",
                "poster_god.jpg",
                "Game Of Thrones",
                "April 17, 2011",
                "4",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst\n" +
                        " the war, a neglected military order of misfits, the Nights Watch, is all that stands between the realms of men and icy horrors beyond."));
        tvs.add(new TvResponse(
                "7",
                "poster_gotham.jpg",
                "Gotham",
                "September 22, 2014",
                "4",
                "Before there was Batman, there was GOTHAM. " +
                        "Everyone knows the name Commissioner Gordon. He is one of the crime worlds greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordons story and his\n" +
                        " rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the worlds most iconic\n" +
                        " villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker? "));
        tvs.add(new TvResponse(
                "8",
                "poster_grey_anatomy.jpg",
                "Greys Anatomy",
                "March 27, 2005",
                "4",
                "Follows the personal and professional lives of a group of doctors at Seattles Grey Sloan Memorial Hospital."));
        tvs.add(new TvResponse(
                "9",
                "poster_hanna.jpg",
                "Hanna",
                "March 28, 2019",
                "4",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she\n" +
                        " is. Based on the 2011 Joe Wright film."));
        return tvs;
    }


}
