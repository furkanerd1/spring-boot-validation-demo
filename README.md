**`@NotNull`**
Ensures that the field is not null.

**`@NotBlank`**
Ensures the field is not null, empty, or only whitespace.

**`@NotEmpty`**
Ensures the field is not null or empty (but allows whitespace).

**`@Size`**
Validates the size of a collection, array, or string (e.g., length or item count).

**`@Min`**
Validates that a numeric value is greater than or equal to a specified minimum.

**`@Max`**
Validates that a numeric value is less than or equal to a specified maximum.

**`@Email`**
Ensures the field contains a valid email format.

**`@Pattern`**
Validates the field against a specified regular expression pattern.

**`@Past`**
Ensures the date is in the past.

**`@Future`**
Ensures the date is in the future.

**`@Positive`**
Validates that a number is strictly greater than zero.

**`@Negative`**
Validates that a number is strictly less than zero.

**` @Digits`**
Validates that a numeric value matches specified integer and fraction digit counts.

**`@DecimalMin / @DecimalMax`**
Validates that a number is within a specified range (for decimal values).

**`@AssertTrue / @AssertFalse`**
Ensures the field is true or false, respectively.
