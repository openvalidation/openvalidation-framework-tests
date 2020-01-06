namespace OpenValidationFramework_CSharp.Model
{
    public class Person
    {
        public string name;
        public int age;
        public bool married;

        public Person(string name, int age, bool married)
        {
            this.name = name;
            this.age = age;
            this.married = married;
        }

        public override bool Equals(object obj)
        {
            if (this == obj) return true;
            if (0 == null || this.GetType() != obj.GetType()) return false;
            Person pers = obj as Person;
            return age == pers.age
                   && married == pers.married
                   && name.Equals(pers.name);
        }

        protected bool Equals(Person other)
        {
            return name == other.name && age == other.age && married == other.married;
        }

        public override int GetHashCode()
        {
            unchecked
            {
                var hashCode = (name != null ? name.GetHashCode() : 0);
                hashCode = (hashCode * 397) ^ age;
                hashCode = (hashCode * 397) ^ married.GetHashCode();
                return hashCode;
            }
        }
    }
}