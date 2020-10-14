from django.shortcuts import render

from django.http.response import JsonResponse
from rest_framework.parsers import JSONParser 
from rest_framework import status
 
from course.models import Course
from course.serializers import CourseSerializer
from rest_framework.decorators import api_view


@api_view(['GET', 'POST', 'DELETE'])
def course_list(request):
    if request.method == 'GET':
        courses = Course.objects.all()
        
        title = request.GET.get('title', None)
        if title is not None:
            courses = courses.filter(title__icontains=title)
        
        courses_serializer = CourseSerializer(courses, many=True)
        return JsonResponse(courses_serializer.data, safe=False)
        # 'safe=False' for objects serialization
 
    elif request.method == 'POST':
        course_data = JSONParser().parse(request)
        course_serializer = CourseSerializer(data=course_data)
        if course_serializer.is_valid():
            course_serializer.save()
            return JsonResponse(course_serializer.data, status=status.HTTP_201_CREATED) 
        return JsonResponse(course_serializer.errors, status=status.HTTP_400_BAD_REQUEST)
    
    elif request.method == 'DELETE':
        count = Course.objects.all().delete()
        return JsonResponse({'message': '{} Courses were deleted successfully!'.format(count[0])}, status=status.HTTP_204_NO_CONTENT)
