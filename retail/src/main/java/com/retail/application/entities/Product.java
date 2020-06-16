package com.retail.application.entities;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.HashMap;
import java.util.Map;

@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@JsonPropertyOrder({
    "available_to_promise_network",
    "question_answer_statistics",
    "item",
    "circle_offers"
})
public class Product {

  @JsonProperty("available_to_promise_network")
  private AvailableToPromiseNetwork availableToPromiseNetwork;
  @JsonProperty("question_answer_statistics")
  private QuestionAnswerStatistics questionAnswerStatistics;
  @JsonProperty("item")
  private Item item;
  @JsonProperty("circle_offers")
  private CircleOffers circleOffers;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("available_to_promise_network")
  public AvailableToPromiseNetwork getAvailableToPromiseNetwork() {
    return availableToPromiseNetwork;
  }

  @JsonProperty("available_to_promise_network")
  public void setAvailableToPromiseNetwork(AvailableToPromiseNetwork availableToPromiseNetwork) {
    this.availableToPromiseNetwork = availableToPromiseNetwork;
  }

  @JsonProperty("question_answer_statistics")
  public QuestionAnswerStatistics getQuestionAnswerStatistics() {
    return questionAnswerStatistics;
  }

  @JsonProperty("question_answer_statistics")
  public void setQuestionAnswerStatistics(QuestionAnswerStatistics questionAnswerStatistics) {
    this.questionAnswerStatistics = questionAnswerStatistics;
  }

  @JsonProperty("item")
  public Item getItem() {
    return item;
  }

  @JsonProperty("item")
  public void setItem(Item item) {
    this.item = item;
  }

  @JsonProperty("circle_offers")
  public CircleOffers getCircleOffers() {
    return circleOffers;
  }

  @JsonProperty("circle_offers")
  public void setCircleOffers(CircleOffers circleOffers) {
    this.circleOffers = circleOffers;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}

