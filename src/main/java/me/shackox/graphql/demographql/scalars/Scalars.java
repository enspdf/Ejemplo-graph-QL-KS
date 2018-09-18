package me.shackox.graphql.demographql.scalars;

import com.zhokhov.graphql.datetime.DateTimeHelper;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

import java.time.LocalDateTime;
import java.util.Date;

public class Scalars {
    public static GraphQLScalarType graphQLDate = new GraphQLScalarType("Date", "Date Scalar", new Coercing() {
        private Date convertValue(Object input) {
            if (input instanceof String) {
                LocalDateTime localDateTime = DateTimeHelper.parseDate((String) input);

                if (localDateTime != null) {
                    return DateTimeHelper.toDate(localDateTime);
                }
            }
            return null;
        }

        @Override
        public String serialize(Object input) {
            if (input instanceof Date) {
                return DateTimeHelper.toISOString((Date) input);
            } else {
                Date result = convertValue(input);
                if (result == null) {
                    throw new CoercingSerializeException("Invalid value '" + input + "' for Date");
                }
                return DateTimeHelper.toISOString(result);
            }
        }

        @Override
        public Date parseValue(Object input) {
            Date result = convertValue(input);
            if (result == null) {
                throw new CoercingParseValueException("Invalid value '" + input + "' for Date");
            }
            return result;
        }

        @Override
        public Date parseLiteral(Object input) {
            if (!(input instanceof StringValue)) return null;
            String value = ((StringValue) input).getValue();
            Date result = convertValue(value);
            return result;
        }
    });
}
