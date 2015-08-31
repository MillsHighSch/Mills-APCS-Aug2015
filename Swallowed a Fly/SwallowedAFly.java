
/**
 * This is a classic children's song about the old lady who swallowed a fly.
 * It did not turn out well for her at all.
 * We will use methods to avoid duplication of code.
 * 
 * @author Steve Lamont
 * @version 31 Aug 2015
 */
public class SwallowedAFly
{
    public static void main(String[] args)
    {
        flyStanza();
        spiderStanza();
        birdStanza();
        catStanza();
        horseStanza();
    }

    public static void wasOldLady()
    {
        // This phrase opens every stanza, so we can avoid some typing by reusing it
        System.out.print("There was an old lady who swallowed a ");
    }

    public static void flyStanza()
    {
        // First stanza is swallowing a fly
        wasOldLady();
        System.out.println("fly.");
        flyRefrain(); //took poetic license to split the second line. Improves reuse
        System.out.println("But it's only a fly");
        System.out.println("I think I'll cry");
        System.out.println("She gulped it out of the sky");
        System.out.println("Oh, my!");
        System.out.println();
    }

    public static void flyRefrain()
    {
        // This refrain repeats in just about every stanza, and is called by other refrains
        System.out.println("I don't know why");
        System.out.println("She swallowed the fly");
        System.out.println("Perhaps she'll die.");
    }

    public static void spiderStanza()
    {
        // Stanza is swallowing a spider to catch the fly
        wasOldLady();
        System.out.println("spider.");
        System.out.println("That wiggled and jiggled and tickled inside her.");
        spiderRefrain();
        System.out.println("Gone to the by and by");
        System.out.println("Sigh.");
        System.out.println();
    }

    public static void spiderRefrain()
    {
        // The refrain calls the flyRefrain
        System.out.println("She swallowed the spider to catch the fly");
        flyRefrain();
    }

    public static void birdStanza()
    {
        // Stanza is swalling a bird to catch the spider
        wasOldLady();
        System.out.println("bird.");
        System.out.println("How absurd, she swallowed a bird!");
        birdRefrain();
        System.out.println("She'll leave us high and dry.");
        System.out.println();

    }

    public static void birdRefrain()
    {
        // Refrain calls the spider refrain
        System.out.println("She swallowed the bird to catch the spider.");
        spiderRefrain();
    }

    public static void catStanza()
    {
        // Stanza is swallowing a cat to catch the bird
        wasOldLady();
        System.out.println("cat.");
        System.out.println("Imagine that! She swallowed a cat.");
        catRefrain();
        System.out.println("I hope it's a lie.");
        System.out.println();
    }

    public static void catRefrain()
    {
        // Refrain calls the bird refrain, and so on
        System.out.println("She swallowed the cat to catch the bird.");
        birdRefrain();
    }

    public static void horseStanza()
    {
        // No repeated text or refrain, so mostly raw print
        wasOldLady();
        System.out.println("horse.");
        System.out.println("She died, of course.");
        System.out.println("It was the last course.");
        System.out.println("I'm filled with remorse.");
        System.out.println("What's left to say...");
        System.out.println("Even the artist is crying.");
        System.out.println("We'll miss her dearly.");
        System.out.println("It is such a loss.");
        System.out.println("She had no time to floss.");
        System.out.println("She missed out on the sauce.");
        System.out.println();
        System.out.println("Moral: Never swallow a horse.");
    }
}
