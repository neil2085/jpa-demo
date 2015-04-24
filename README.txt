# Project Name

JPA demo


## Usage

1.JPA only looks at the owning side of relationship when persisting it
2."Mappedby" is a field name on the referencing  bean
3.Bidirectional relationship provides navigational access in both directions, but that navigational access is not always good, especially for "one-to-very-many" and "many-to-very-many" relationships, which is not good for performance if the one side has thousand items