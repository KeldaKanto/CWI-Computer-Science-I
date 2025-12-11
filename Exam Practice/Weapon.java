/**
 * Represents a DnD weapon.
 */
public class Weapon {
    private final String name;
    private final Die damageDie;
    private int lastDamage;
    private int attacksRemaining;

    /**
     * Constructs a weapon with a name and die.
     * @param name Defines the name of the weapon.
     * @param damageDie Defines which die to use.
     */
    public Weapon(String name, Die damageDie) {
        this.name = name;
        this.damageDie = damageDie;
        lastDamage = 0;
        attacksRemaining = 4;
    }

    /**
     * Accesses the weapon's name.
     * @return A String of the weapon's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Accesses the damageDie.
     * @return The Die damageDie.
     */
    public Die getDamageDie() {
        return damageDie;
    }

    /**
     * Accesses the damage value of the last weapon attack.
     * @return An integer value of the weapon's last attack.
     */
    public int getLastDamage() {
        return lastDamage;
    }

    /**
     * Rolls a die for the weapon's attack value and decrements
     * the number of attacks remaining.
     */
    public void attack() {
        lastDamage = damageDie.roll();
        attacksRemaining--;
    }

    /**
     * Accesses the number of attacks this weapon has remaining.
     * @return An integer of the remaining attacks.
     */
    public int getAttacksRemaining() {
        return attacksRemaining;
    }

    /**
     * Returns a string representation of the weapon.
     * @return The name of the weapon and, if it's damage is
     * greater than zero, the last damage value.
     */
    @Override
    public String toString() {
       if (getLastDamage() > 0) {
           return getName() + " - Damage: " + getLastDamage();
       } else {
           return getName();
       }
    }
}
