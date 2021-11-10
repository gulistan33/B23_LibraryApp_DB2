package com.library.step_definitions;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BookStepDefs {
    String actualCategory;

    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
        String query = "select bc.name,count(*) from book_borrow bb inner join books b on bb.book_id = b.id\n" +
                "inner join book_categories bc on b.book_category_id = bc.id\n" +
                "group by bc.name\n" +
                "order by 2 desc ";

        DB_Util.runQuery(query);
        actualCategory = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualCategory = " + actualCategory);

    }

    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedCategory) {

        Assert.assertEquals(expectedCategory, actualCategory);
    }

    String actualUser;

    @When("I execute query to find most popular user")
    public void i_execute_query_to_find_most_popular_user() {
        String query = "select full_name,count(*) from users u inner join book_borrow bb on u.id = bb.user_id\n" +
                "group by full_name\n" +
                "order by 2 desc ";
        DB_Util.runQuery(query);
        actualUser = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUser = " + actualUser);
    }

    @Then("verify {string} is the user who reads the most")
    public void verify_is_the_user_who_reads_the_most(String expectedUser) {
        Assert.assertEquals(expectedUser, actualUser);
    }
}
